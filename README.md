# essentials4j - the perfect library for every Java 8 project!

Essentials4j is a minimalistic library consisting of:
 - a thin layer of abstraction over Java 8 streams for easy manipulation of collections,
 - simple factory utils for elegant construction of collections.

Java 8 streams are powerful, and essentials4j is just a fantastic way to use them!

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

### Maven dependency

```xml
 <dependency>
    <groupId>org.essentials4j</groupId>
    <artifactId>essentials4j</artifactId>
    <version>1.0.0</version>
</dependency>
```

### API

#### Instantiation:

```java
List<E>   list  =  New.list(...)
Set<E>    set   =  New.set(...)
Map<K,V>  map   =  New.map(...)
```

#### Searching:

```java
List<E>      results  =  Do.findIn(items).all(predicate)
Optional<E>  any      =  Do.findIn(items).any(predicate)
Optional<E>  first    =  Do.findIn(items).first(predicate)
Optional<E>  last     =  Do.findIn(items).last(predicate)
boolean      exists   =  Do.findIn(items).exists(predicate)
```

#### Transforming:

```java
List<E>   list  =  Do.map(items).toList(transformation)
List<E>   set   =  Do.map(items).toSet(transformation)
Map<K,V>  map   =  Do.map(items).toMap(keyTransformation, valueTransformation)
```

#### Grouping by classifier:

```java
Map<T, List<E>>   groups  =  Do.group(collection).by(classifier)
Map<T, Map<K,V>>  groups  =  Do.group(map).by(classifier)
```

### Examples: searching through collections

Let's search through this list of items in the following examples:

```java
List<String> abc = New.list("a", "bbb", "cc");
```

#### Find all:

```java
List<String> words = Do.findIn(abc).all(s -> s.length() > 1); // ["bbb", "cc"]
```

#### Find any:

```java
Optional<String> anyLetter = Do.findIn(abc).any(s -> s.length() == 1); // "a"
```

#### Find first:

```java
Optional<String> firstWord = Do.findIn(abc).first(s -> s.length() > 1); // "bbb"
```

#### Find last:

```java
Optional<String> lastWord = Do.findIn(abc).last(s -> s.length() > 1); // "cc"
```

#### Exists:

```java
boolean hasLetter = Do.findIn(abc).exists(s -> s.length() == 1) // true
```

### Examples: mapping and grouping collections

Let's transform this list of items in the following examples:

```java
List<String> abc = New.list("a", "bb", "cc");
```

#### Mapping to a List:

```java
List<Integer> lengths = Do.map(abc).toList(String::length); // [1, 2, 2]
```

#### Mapping to a Set:

```java
Set<Integer> lengths2 = Do.map(abc).toSet(String::length);  // [1, 2]
```

#### Mapping to a Map:

```java
Map<String, Integer> lengths3 = Do.map(abc).toMap(s -> s, String::length); // {"a":1, "bb":2, "cc":2}
```

#### Group by:

```java
Map<Integer, List<String>> byLength = Do.group(abc).by(String::length); // {1:["a"], 2:["bb", "cc"]}
```

### Examples: searching through maps

Let's search through this map of items in the following examples:

```java
Map<Integer, String> nums = New.map(-1, "neg", 0, "zero", 1, "pos");
```

#### Find all:

```java
Map<Integer, String> notNegative = Do.findIn(nums).all((k, v) -> k >= 0); // {0:"zero", 1:"pos"}
```

#### Find any:

```java
Optional<Entry<Integer, String>> anyPositive = Do.findIn(nums).any((k, v) -> k > 0); // 1:"pos"
```

#### Find first:

```java
Optional<Entry<Integer, String>> firstNonZero = Do.findIn(nums).first((k, v) -> k != 0); // -1:"neg"
```

#### Find last:

```java
Optional<Entry<Integer, String>> lastNonZero = Do.findIn(nums).last((k, v) -> k != 0); // 1:"pos"
```

#### Exists:

```java
boolean hasPositive = Do.findIn(nums).exists((k, v) -> k > 0); // true
```

### Examples: mapping and grouping maps

Let's transform this map of items in the following examples:

```java
Map<Integer, String> nums = New.map(1, "one", 2, "two", 3, "three");
```

#### Mapping to a List:

```java
List<Integer> squared = Do.map(nums).toList((k, v) -> k * k); // [1, 4, 9]
```

#### Mapping to a Set:

```java
Set<Integer> wordLengths = Do.map(nums).toSet((k, v) -> v.length()); // [3, 5]
```

#### Mapping to a Map:

```java
// {1000:"ONE", 2000:"TWO", 3000:"THREE"}
Map<Integer, String> thousands = Do.map(nums).toMap((k, v) -> k * 1000, (k, v) -> v.toUpperCase());
```

#### Group by:

```java
// { false: {1:"one", 3:"three"}, true: {2:two} }
Map<Boolean, Map<Integer, String>> even = Do.group(nums).by((k, v) -> k % 2 == 0);
```
