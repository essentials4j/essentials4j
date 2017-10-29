package org.essentials4j;

/*
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

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public final class New {

	private New() {
	}

	public static <T> Set<T> set() {
		return new LinkedHashSet<>();
	}

	public static <T> Set<T> set(Iterable<? extends T> values) {
		Objects.requireNonNull(values);
		Set<T> set = set();

		for (T val : values) {
			set.add(val);
		}

		return set;
	}

	@SafeVarargs
	@SuppressWarnings({"varargs", "unchecked"})
	public static <T> Set<T> set(T... values) {
		Objects.requireNonNull(values);
		Set<T> set = set();

		Collections.addAll(set, values);

		return set;
	}

	public static <T> List<T> list() {
		return new ArrayList<>();
	}

	public static <T> List<T> list(Iterable<? extends T> values) {
		Objects.requireNonNull(values);
		List<T> list = list();

		for (T item : values) {
			list.add(item);
		}

		return list;
	}

	@SafeVarargs
	@SuppressWarnings({"varargs", "unchecked"})
	public static <T> List<T> list(T... values) {
		Objects.requireNonNull(values);
		List<T> list = list();

		Collections.addAll(list, values);

		return list;
	}

	public static <K, V> Map<K, V> map() {
		return new LinkedHashMap<>();
	}

	public static <K, V> Map<K, V> map(Map<? extends K, ? extends V> src) {
		Objects.requireNonNull(src);
		Map<K, V> map = map();

		map.putAll(src);

		return map;
	}

	public static <K, V> Map<K, V> map(K key, V value) {
		Map<K, V> map = map();
		map.put(key, value);
		return map;
	}

	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2) {
		Map<K, V> map = map(key1, value1);
		map.put(key2, value2);
		return map;
	}

	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3) {
		Map<K, V> map = map(key1, value1, key2, value2);
		map.put(key3, value3);
		return map;
	}

	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
		Map<K, V> map = map(key1, value1, key2, value2, key3, value3);
		map.put(key4, value4);
		return map;
	}

	public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5, V value5) {
		Map<K, V> map = map(key1, value1, key2, value2, key3, value3, key4, value4);
		map.put(key5, value5);
		return map;
	}

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

	public static <T> Stream<T> stream(Iterable<T> items) {
		Objects.requireNonNull(items);

		return StreamSupport.stream(items.spliterator(), false);
	}

}
