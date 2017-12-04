/*-
 * #%L
 * essentials4j
 * %%
 * Copyright (C) 2017 Nikolche Mihajlovski
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.essentials4j;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Static utilities for easy construction of collections and streams.
 *
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public final class New {

	/**
	 * Static utilities. Do not instantiate.
	 */
	private New() {
	}

	/* stream */

	/**
	 * Creates a new sequential {@code Stream} from the specified {@code Iterable} items.
	 *
	 * @param items the iterable items to create stream from.
	 * @param <T>   the type of the items
	 * @return a new sequential {@code Stream} from the specified items
	 */
	public static <T> Stream<T> stream(Iterable<T> items) {
		Objects.requireNonNull(items);

		return StreamSupport.stream(items.spliterator(), false);
	}

	/* set */

	/**
	 * Constructs a new empty insertion-ordered {@code LinkedHashSet} instance.
	 *
	 * @param <T> the type of the set elements
	 * @return a new empty insertion-ordered {@code LinkedHashSet} instance
	 */
	public static <T> Set<T> set() {
		return new LinkedHashSet<>();
	}

	/**
	 * Constructs a new insertion-ordered {@code LinkedHashSet} instance and adds the specified elements to it.
	 *
	 * @param elements the elements that will be added to the new set
	 * @param <T>      the type of the set elements
	 * @return a new insertion-ordered {@code LinkedHashSet} instance consisting of the specified elements
	 * @throws NullPointerException if {@code elements} is {@code null}
	 */
	public static <T> Set<T> set(Iterable<? extends T> elements) {
		Objects.requireNonNull(elements);
		Set<T> set = set();

		for (T val : elements) {
			set.add(val);
		}

		return set;
	}

	/**
	 * Constructs a new insertion-ordered {@code LinkedHashSet} instance and adds the specified elements to it.
	 *
	 * @param elements the elements that will be added to the new set
	 * @param <T>      the type of the set elements
	 * @return a new insertion-ordered {@code LinkedHashSet} instance consisting of the specified elements
	 * @throws NullPointerException if {@code elements} is {@code null}
	 */
	@SafeVarargs
	@SuppressWarnings({"varargs", "unchecked"})
	public static <T> Set<T> set(T... elements) {
		Objects.requireNonNull(elements);
		Set<T> set = set();

		Collections.addAll(set, elements);

		return set;
	}

	/* list */

	/**
	 * Constructs a new empty {@code ArrayList} instance.
	 *
	 * @param <T> the type of the list elements
	 * @return a new empty {@code ArrayList} instance
	 */
	public static <T> List<T> list() {
		return new ArrayList<>();
	}

	/**
	 * Constructs a new {@code ArrayList} instance and adds the specified elements to it.
	 *
	 * @param elements the elements that will be added to the new list
	 * @param <T>      the type of the list elements
	 * @return a new {@code ArrayList} instance consisting of the specified elements
	 * @throws NullPointerException if {@code elements} is {@code null}
	 */
	public static <T> List<T> list(Iterable<? extends T> elements) {
		Objects.requireNonNull(elements);
		List<T> list = list();

		for (T item : elements) {
			list.add(item);
		}

		return list;
	}

	/**
	 * Constructs a new {@code ArrayList} instance and adds the specified elements to it.
	 *
	 * @param elements the elements that will be added to the new list
	 * @param <T>      the type of the list elements
	 * @return a new {@code ArrayList} instance consisting of the specified elements
	 * @throws NullPointerException if {@code elements} is {@code null}
	 */
	@SafeVarargs
	@SuppressWarnings({"varargs", "unchecked"})
	public static <T> List<T> list(T... elements) {
		Objects.requireNonNull(elements);
		List<T> list = list();

		Collections.addAll(list, elements);

		return list;
	}

	/* map */

	/**
	 * Constructs an empty insertion-ordered {@code LinkedHashMap} instance.
	 *
	 * @param <K> the type of the map keys
	 * @param <V> the type of the map values
	 * @return a new empty {@code LinkedHashMap} instance
	 */
	public static <K, V> Map<K, V> map() {
		return new LinkedHashMap<>();
	}

	/**
	 * Constructs an insertion-ordered {@code LinkedHashMap} instance with the same entries as the specified source map.
	 *
	 * @param source the source map whose entries are being copied into a new map
	 * @param <K>    the type of the map keys
	 * @param <V>    the type of the map values
	 * @return a new {@code LinkedHashMap} instance consisting of the same entries as the specified source map
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static <K, V> Map<K, V> map(Map<? extends K, ? extends V> source) {
		Objects.requireNonNull(source);
		Map<K, V> map = map();

		map.putAll(source);

		return map;
	}

	/**
	 * Constructs an insertion-ordered {@code LinkedHashMap} instance with a single entry (specified as a key-value pair).
	 *
	 * @param key   the key of the map's single entry
	 * @param value the value of the map's single entry
	 * @param <K>   the type of the map keys
	 * @param <V>   the type of the map values
	 * @return a new {@code LinkedHashMap} instance consisting of the specified key-value pair as entry
	 */
	public static <K, V> Map<K, V> map(K key, V value) {
		Map<K, V> map = map();
		map.put(key, value);
		return map;
	}

	/**
	 * Constructs an insertion-ordered {@code LinkedHashMap} instance with 2 entries (specified as key-value pairs).
	 *
	 * @param key1   the key of the map's 1st entry
	 * @param value1 the value of the map's 1st entry
	 * @param key2   the key of the map's 2nd entry
	 * @param value2 the value of the map's 2nd entry
	 * @param <K>    the type of the map keys
	 * @param <V>    the type of the map values
	 * @return a new {@code LinkedHashMap} instance consisting of the specified key-value pairs as entries
	 */
	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2) {
		Map<K, V> map = map(key1, value1);
		map.put(key2, value2);
		return map;
	}

	/**
	 * Constructs an insertion-ordered {@code LinkedHashMap} instance with 3 entries (specified as key-value pairs).
	 *
	 * @param key1   the key of the map's 1st entry
	 * @param value1 the value of the map's 1st entry
	 * @param key2   the key of the map's 2nd entry
	 * @param value2 the value of the map's 2nd entry
	 * @param key3   the key of the map's 3rd entry
	 * @param value3 the value of the map's 3rd entry
	 * @param <K>    the type of the map keys
	 * @param <V>    the type of the map values
	 * @return a new {@code LinkedHashMap} instance consisting of the specified key-value pairs as entries
	 */
	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3) {
		Map<K, V> map = map(key1, value1, key2, value2);
		map.put(key3, value3);
		return map;
	}

	/**
	 * Constructs an insertion-ordered {@code LinkedHashMap} instance with 4 entries (specified as key-value pairs).
	 *
	 * @param key1   the key of the map's 1st entry
	 * @param value1 the value of the map's 1st entry
	 * @param key2   the key of the map's 2nd entry
	 * @param value2 the value of the map's 2nd entry
	 * @param key3   the key of the map's 3rd entry
	 * @param value3 the value of the map's 3rd entry
	 * @param key4   the key of the map's 4th entry
	 * @param value4 the value of the map's 4th entry
	 * @param <K>    the type of the map keys
	 * @param <V>    the type of the map values
	 * @return a new {@code LinkedHashMap} instance consisting of the specified key-value pairs as entries
	 */
	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
		Map<K, V> map = map(key1, value1, key2, value2, key3, value3);
		map.put(key4, value4);
		return map;
	}

	/**
	 * Constructs an insertion-ordered {@code LinkedHashMap} instance with 5 entries (specified as key-value pairs).
	 *
	 * @param key1   the key of the map's 1st entry
	 * @param value1 the value of the map's 1st entry
	 * @param key2   the key of the map's 2nd entry
	 * @param value2 the value of the map's 2nd entry
	 * @param key3   the key of the map's 3rd entry
	 * @param value3 the value of the map's 3rd entry
	 * @param key4   the key of the map's 4th entry
	 * @param value4 the value of the map's 4th entry
	 * @param key5   the key of the map's 5th entry
	 * @param value5 the value of the map's 5th entry
	 * @param <K>    the type of the map keys
	 * @param <V>    the type of the map values
	 * @return a new {@code LinkedHashMap} instance consisting of the specified key-value pairs as entries
	 */
	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5, V value5) {
		Map<K, V> map = map(key1, value1, key2, value2, key3, value3, key4, value4);
		map.put(key5, value5);
		return map;
	}

	/**
	 * Constructs an insertion-ordered {@code LinkedHashMap} instance with {@code N} entries (specified as key-value pairs).
	 *
	 * @param keysAndValues the map's key-value pairs, in the form: {@code key1, value1, ..., keyN, valueN}
	 * @param <K>           the type of the map keys
	 * @param <V>           the type of the map values
	 * @return a new {@code LinkedHashMap} instance consisting of the specified key-value pairs as entries
	 * @throws NullPointerException if {@code keysAndValues} is {@code null}
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> map(Object... keysAndValues) {
		Objects.requireNonNull(keysAndValues);

		if (keysAndValues.length % 2 != 0) {
			throw new IllegalArgumentException("Expected even number of arguments (key-value pairs)!");
		}

		Map<K, V> map = map();

		for (int i = 0; i < keysAndValues.length / 2; i++) {
			map.put((K) keysAndValues[i * 2], (V) keysAndValues[i * 2 + 1]);
		}

		return map;
	}

}
