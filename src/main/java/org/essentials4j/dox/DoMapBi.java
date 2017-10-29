package org.essentials4j.dox;

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

import org.essentials4j.To;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class DoMapBi<K, V> {

	private final Map<K, V> items;

	public DoMapBi(Map<K, V> items) {
		this.items = items;
	}

	public <K2, V2> Map<K2, V2> toMap(BiFunction<K, V, ? extends K2> keyTransformation,
	                                  BiFunction<K, V, ? extends V2> valueTransformation) {
		return items.entrySet().stream()
			.collect(To.map(
				e -> keyTransformation.apply(e.getKey(), e.getValue()),
				e -> valueTransformation.apply(e.getKey(), e.getValue())
			));
	}

	public <R> List<R> toList(BiFunction<K, V, R> transformation) {
		return items.entrySet().stream()
			.map(e -> transformation.apply(e.getKey(), e.getValue()))
			.collect(To.list());
	}

	public <R> Set<R> toSet(BiFunction<K, V, R> transformation) {
		return items.entrySet().stream()
			.map(e -> transformation.apply(e.getKey(), e.getValue()))
			.collect(To.set());
	}

}
