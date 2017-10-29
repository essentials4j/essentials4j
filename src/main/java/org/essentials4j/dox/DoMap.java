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
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class DoMap<T> {

	private final Stream<T> stream;

	public DoMap(Stream<T> stream) {
		this.stream = stream;
	}

	public <R> List<R> toList(Function<T, R> transformation) {
		return stream.map(transformation).collect(To.list());
	}

	public <R> Set<R> toSet(Function<T, R> transformation) {
		return stream.map(transformation).collect(To.set());
	}

	public <K, V> Map<K, V> toMap(Function<T, K> keyMapper, Function<T, V> valueMapper) {
		return stream.collect(To.map(keyMapper, valueMapper));
	}

}
