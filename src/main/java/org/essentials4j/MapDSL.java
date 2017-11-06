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

import org.essentials4j.To;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class MapDSL<T> {

	private final Stream<T> stream;

	public MapDSL(Stream<T> stream) {
		this.stream = stream;
	}

	/**
	 * Maps (transforms) the pre-specified items by applying the specified transformation function.
	 * <p>
	 * The resulting elements derived from this transformation are stored into a new {@code List}.
	 *
	 * @param transformation the transformation function used to derive a resulting element from each item
	 * @return a new {@code List} consisting of the derived elements
	 * @throws NullPointerException if {@code transformation} is {@code null}
	 */
	public <R> List<R> toList(Function<T, R> transformation) {
		return stream.map(transformation).collect(To.list());
	}

	/**
	 * Maps (transforms) the pre-specified items by applying the specified transformation function.
	 * <p>
	 * The resulting elements derived from this transformation are stored into a new {@code Set}.
	 *
	 * @param transformation the transformation function used to derive a resulting element from each item
	 * @return a new {@code Set} consisting of the derived elements
	 * @throws NullPointerException if {@code transformation} is {@code null}
	 */
	public <R> Set<R> toSet(Function<T, R> transformation) {
		return stream.map(transformation).collect(To.set());
	}

	/**
	 * Maps (transforms) the pre-specified items by applying the specified transformation function.
	 * <p>
	 * The resulting elements derived from this transformation are stored into a new {@code Map}.
	 *
	 * @param keyTransformation   the transformation function used to derive a resulting entry key from each item
	 * @param valueTransformation the transformation function used to derive a resulting entry value from each item
	 * @return a new {@code Map} consisting of the derived {@code (key, value)} entries
	 * @throws NullPointerException if {@code keyTransformation} is {@code null} or {@code valueTransformation} is {@code null}
	 */
	public <K, V> Map<K, V> toMap(Function<T, K> keyTransformation, Function<T, V> valueTransformation) {
		return stream.collect(To.map(keyTransformation, valueTransformation));
	}

}
