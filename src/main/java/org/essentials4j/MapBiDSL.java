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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * DSL helper used to specify transformation function and execute the mapping through method chain call.
 *
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class MapBiDSL<K, V> {

	private final Map<K, V> items;

	MapBiDSL(Map<K, V> items) {
		this.items = items;
	}

	/**
	 * Maps (transforms) the pre-specified items ({@code Map} entries) by applying the specified transformation function.
	 * <p>
	 * The resulting elements derived from this transformation are stored into a new {@code List}.
	 *
	 * @param transformation the transformation function used to derive a resulting element from each {@code (key, value)} entry
	 * @return a new {@code List} consisting of the derived elements
	 * @throws NullPointerException if {@code transformation} is {@code null}
	 */
	public <R> List<R> toList(BiFunction<? super K, ? super V, ? extends R> transformation) {
		return items.entrySet().stream()
			.map(e -> transformation.apply(e.getKey(), e.getValue()))
			.collect(To.list());
	}

	/**
	 * Maps (transforms) the pre-specified items ({@code Map} entries) by applying the specified transformation function.
	 * <p>
	 * The resulting elements derived from this transformation are stored into a new {@code Set}.
	 *
	 * @param transformation the transformation function used to derive a resulting element from each {@code (key, value)} entry
	 * @return a new {@code Set} consisting of the derived elements
	 * @throws NullPointerException if {@code transformation} is {@code null}
	 */
	public <R> Set<R> toSet(BiFunction<? super K, ? super V, ? extends R> transformation) {
		return items.entrySet().stream()
			.map(e -> transformation.apply(e.getKey(), e.getValue()))
			.collect(To.set());
	}

	/**
	 * Maps (transforms) the pre-specified items ({@code Map} entries) by applying the specified transformation function.
	 * <p>
	 * The resulting elements derived from this transformation are stored into a new {@code Map}.
	 *
	 * @param keyTransformation   the transformation function used to derive a resulting entry key from each {@code (key, value)} entry
	 * @param valueTransformation the transformation function used to derive a resulting entry value from each {@code (key, value)} entry
	 * @return a new {@code Map} consisting of the derived {@code (key, value)} entries
	 * @throws NullPointerException if {@code keyTransformation} is {@code null} or {@code valueTransformation} is {@code null}
	 */
	public <K2, V2> Map<K2, V2> toMap(BiFunction<? super K, ? super V, ? extends K2> keyTransformation,
	                                  BiFunction<? super K, ? super V, ? extends V2> valueTransformation) {
		return items.entrySet().stream()
			.collect(To.map(
				e -> keyTransformation.apply(e.getKey(), e.getValue()),
				e -> valueTransformation.apply(e.getKey(), e.getValue())
			));
	}

}
