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
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * DSL helper used to specify classification function and execute the grouping through method chain call.
 *
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class GroupBiDSL<K, V> {

	private final Map<K, V> items;

	GroupBiDSL(Map<K, V> items) {
		this.items = items;
	}

	/**
	 * Groups the pre-specified items ({@code Map} entries) according to the specified classification function, which maps each entry to a classification key.
	 * <p>
	 * The resulting groups of entries are stored into a new {@code Map} with the following structure:
	 * <p>
	 * - keys: the distinct set of classification keys,
	 * <p>
	 * - values: for each classification key, a {@code Map} of all entries that were mapped to that key.
	 *
	 * @param classifier the classification function used to group the items
	 * @return a new {@code Map} consisting of the grouped items
	 * @throws NullPointerException if {@code classifier} is {@code null}
	 */
	public <R> Map<R, Map<K, V>> by(BiFunction<? super K, ? super V, ? extends R> classifier) {
		return items.entrySet().stream()
			.collect(Collectors.groupingBy(e -> classifier.apply(e.getKey(), e.getValue()), New::map, To.map()));
	}

}
