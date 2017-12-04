# essentials4j - the perfect library for every Java 8 project!

Essentials4j is a minimalistic library consisting of:
 - a thin layer of abstraction over Java 8 streams for easy manipulation of collections,
 - simple factory utils for elegant construction of collections.

## Why essentials4j? To make the simple things - simple!

Java 8 streams and collections are very powerful, but very often we have not use & manipulate them in a verbose way. Essentials4j offers a simpler way to do this.

For example, with essentials4j we could write code like:

```java
Map<Integer, String> nums = New.map(1, "one", 2, "two", 3, "three");

Map<Integer, String> even = Do.findIn(nums).all((k, v) -> k % 2 == 0); // {2:"two"}
```

The code above is just a shortcut for:

```java
Map<Integer, String> nums = new LinkedHashMap<>();
nums.put(1, "one");
nums.put(2, "two");
nums.put(3, "three");

Map<Integer, String> even = nums().entrySet().stream()
    .filter(entry -> entry.getKey() % 2 == 0)
    .collect(Collectors.toMap(Entry::getKey, Entry::getValue)); // {2:"two"}
```

## Maven dependency (NOT RELEASED YET):

```xml
 <dependency>
    <groupId>org.essentials4j</groupId>
    <artifactId>essentials4j</artifactId>
    <version>1.0.0</version>
</dependency>
```