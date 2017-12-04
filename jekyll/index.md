---
layout: page
---

# What is essentials4j?

Essentials4j is a minimalistic library consisting of:
 - a thin layer of abstraction over Java 8 streams for easy manipulation of collections,
 - simple factory utils for elegant construction of collections.

## Example

```java
Map<Integer, String> nums = New.map(1, "one", 2, "two", 3, "three");

Map<Integer, String> even = Do.findIn(nums).all((k, v) -> k % 2 == 0); // {2:"two"}
```

### The code above is a shortcut for:

```java
Map<Integer, String> nums = new LinkedHashMap<>();
nums.put(1, "one");
nums.put(2, "two");
nums.put(3, "three");

Map<Integer, String> even = nums.entrySet().stream()
    .filter(entry -> entry.getKey() % 2 == 0)
    .collect(Collectors.toMap(Entry::getKey, Entry::getValue)); // {2:"two"}
```

## Features

What makes essentials4j perfect?
 - Simple, elegant & straight to the point
 - 100% test coverage
 - 100% documentation coverage
 - Open-source (Apache Public License v2)
 - Lightweight (consists of only 9 classes)
 - Self-contained (no dependencies)
 - Only 15 KB JAR size

## Usage

### Searching through collections

```java
List<String> abc = New.list("a", "bbb", "cc");

boolean hasLetter = Do.findIn(abc).exists(s -> s.length() == 1) // true

List<String> words = Do.findIn(abc).all(s -> s.length() > 1); // ["bbb", "cc"]

Optional<String> anyLetter = Do.findIn(abc).any(s -> s.length() == 1); // "a"

Optional<String> firstWord = Do.findIn(abc).first(s -> s.length() > 1); // "bbb"

Optional<String> lastWord = Do.findIn(abc).last(s -> s.length() > 1); // "cc"
```

### Mapping and grouping collections

```java
List<String> abc = New.list("a", "bb", "cc");

List<Integer> lengths = Do.map(abc).toList(String::length); // [1, 2, 2]

Set<Integer> lengths2 = Do.map(abc).toSet(String::length);  // [1, 2]

Map<String, Integer> lengths3 = Do.map(abc).toMap(s -> s, String::length); // {"a":1, "bb":2, "cc":2}

Map<Integer, List<String>> byLength = Do.group(abc).by(String::length); // {1:["a"], 2:["bb", "cc"]}
```

### Searching through maps

```java
Map<Integer, String> nums = New.map(-1, "neg", 0, "zero", 1, "pos");

boolean hasPositive = Do.findIn(nums).exists((k, v) -> k > 0); // true

Map<Integer, String> notNegative = Do.findIn(nums).all((k, v) -> k >= 0); // {0:"zero", 1:"pos"}

Optional<Entry<Integer, String>> anyPositive = Do.findIn(nums).any((k, v) -> k > 0); // 1:"pos"

Optional<Entry<Integer, String>> firstNonZero = Do.findIn(nums).first((k, v) -> k != 0); // -1:"neg"

Optional<Entry<Integer, String>> lastNonZero = Do.findIn(nums).last((k, v) -> k != 0); // 1:"pos"
```

### Mapping and grouping maps

```java
Map<Integer, String> nums = New.map(1, "one", 2, "two", 3, "three");

List<Integer> squared = Do.map(nums).toList((k, v) -> k * k); // [1, 4, 9]

Set<Integer> wordLengths = Do.map(nums).toSet((k, v) -> v.length()); // [3, 5]

// {1000:"ONE", 2000:"TWO", 3000:"THREE"}
Map<Integer, String> thousands = Do.map(nums).toMap((k, v) -> k * 1000, (k, v) -> v.toUpperCase());

// { false: {1:"one", 3:"three"}, true: {2:two} }
Map<Boolean, Map<Integer, String>> even = Do.group(nums).by((k, v) -> k % 2 == 0);
```

## Maven dependency:

```xml
 <dependency>
    <groupId>org.essentials4j</groupId>
    <artifactId>essentials4j</artifactId>
    <version>1.0.0</version>
</dependency>
```
