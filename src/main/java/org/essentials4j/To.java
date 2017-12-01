package org.essentials4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

/**
 * Stream collectors.
 *
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public final class To {

	private static final BinaryOperator<?> THROWING_MERGER = (oldValue, newValue) -> {
		throw new IllegalArgumentException(String.format("Both values [%s] and [%s] have the same key!", oldValue, newValue));
	};

	/**
	 * Static utilities. Do not instantiate.
	 */
	private To() {
	}

	/**
	 * Returns a {@code Collector} that accumulates the input elements into a new {@code List}.
	 * <p>
	 * Equivalent to {@code Collectors.toList()}.
	 *
	 * @param <T> the type of the output list elements
	 * @return a new collector that accumulates the input elements into a new {@code List}
	 * @see Collectors#toList()
	 */
	public static <T> Collector<T, ?, List<T>> list() {
		return Collectors.toList();
	}

	/**
	 * Returns a {@code Collector} that accumulates the input elements into a new {@code Set}.
	 * <p>
	 * Equivalent to {@code Collectors.toSet()}.
	 *
	 * @param <T> the type of the output set elements
	 * @return a new collector that accumulates the input elements into a new {@code Set}
	 * @see Collectors#toSet()
	 */
	public static <T> Collector<T, ?, Set<T>> set() {
		return Collectors.toSet();
	}

	/**
	 * Returns a {@code Collector} that accumulates the input map entries into a new {@code LinkedHashMap}.
	 *
	 * @param <K> the type of the output map keys
	 * @param <V> the type of the output map values
	 * @return a new collector that accumulates the input map entries into a new {@code LinkedHashMap}
	 * @see #map(Function, Function)
	 */
	public static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> map() {
		return map(Map.Entry::getKey, Map.Entry::getValue);
	}

	/**
	 * Returns a {@code Collector} that accumulates the input elements into a new {@code LinkedHashMap}.
	 *
	 * @param keyTransformation   the transformation function used to derive a resulting entry key from each item
	 * @param valueTransformation the transformation function used to derive a resulting entry value from each item
	 * @param <T>                 the type of the input elements
	 * @param <K>                 the type of the output map keys
	 * @param <V>                 the type of the output map values
	 * @return a new collector that accumulates the input elements into a new {@code LinkedHashMap}
	 * @see #map()
	 */
	public static <T, K, V> Collector<T, ?, Map<K, V>> map(Function<? super T, ? extends K> keyTransformation,
	                                                       Function<? super T, ? extends V> valueTransformation) {

		BinaryOperator<V> merger = throwingMerger();

		return Collectors.toMap(keyTransformation, valueTransformation, merger, New::map);
	}

	@SuppressWarnings("unchecked")
	private static <V> BinaryOperator<V> throwingMerger() {
		return (BinaryOperator<V>) THROWING_MERGER;
	}

}
