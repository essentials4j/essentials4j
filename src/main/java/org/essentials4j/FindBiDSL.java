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

import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;

/**
 * DSL helper used to specify search criteria and execute the search through method chain call.
 *
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class FindBiDSL<K, V> {

	private final Map<K, V> items;

	FindBiDSL(Map<K, V> items) {
		this.items = items;
	}

	/**
	 * Searches through the pre-specified items ({@code Map} entries) for the existence of any entry that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function, to be applied on {@code (key, value)} entries
	 * @return {@code true} if any matching entry has been found, or {@code false} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public boolean exists(BiPredicate<? super K, ? super V> predicate) {
		return items.entrySet().stream()
			.anyMatch(e -> predicate.test(e.getKey(), e.getValue()));
	}

	/**
	 * Searches through the pre-specified items ({@code Map} entries) for the first entry that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function, to be applied on {@code (key, value)} entries
	 * @return {@code Optional} wrapping the first matching entry if it has been found, or an empty {@code Optional} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public Optional<Map.Entry<K, V>> first(BiPredicate<? super K, ? super V> predicate) {
		return items.entrySet().stream()
			.filter(e -> predicate.test(e.getKey(), e.getValue()))
			.findFirst();
	}

	/**
	 * Searches through the pre-specified items ({@code Map} entries) for the last entry that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function, to be applied on {@code (key, value)} entries
	 * @return {@code Optional} wrapping the last matching entry if it has been found, or an empty {@code Optional} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public Optional<Map.Entry<K, V>> last(BiPredicate<? super K, ? super V> predicate) {
		return items.entrySet().stream()
			.filter(e -> predicate.test(e.getKey(), e.getValue()))
			.reduce((prev, next) -> next);
	}

	/**
	 * Searches through the pre-specified items ({@code Map} entries) for any entry that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function, to be applied on {@code (key, value)} entries
	 * @return {@code Optional} wrapping any matching entry if it has been found, or an empty {@code Optional} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public Optional<Map.Entry<K, V>> any(BiPredicate<? super K, ? super V> predicate) {
		return items.entrySet().stream()
			.filter(e -> predicate.test(e.getKey(), e.getValue()))
			.findAny();
	}

	/**
	 * Searches through the pre-specified items ({@code Map} entries) for all entries that satisfy the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function, to be applied on {@code (key, value)} entries
	 * @return a new {@code Map} consisting of all matching entries that have been found, if any
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public Map<K, V> all(BiPredicate<? super K, ? super V> predicate) {
		return items.entrySet().stream()
			.filter(e -> predicate.test(e.getKey(), e.getValue()))
			.collect(To.map());
	}

}
