package org.essentials4j;

import org.essentials4j.dox.*;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

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
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public final class Do {

	private Do() {
	}

	public static <T> DoMap<T> map(Iterable<T> items) {
		return map(New.stream(items));
	}

	public static <T> DoMap<T> map(Stream<T> stream) {
		return new DoMap<>(stream);
	}

	@SuppressWarnings("unchecked")
	public static <K, V> DoMapBi<K, V> map(Map<K, V> items) {
		return new DoMapBi<K, V>(items != null ? items : Collections.EMPTY_MAP);
	}

	public static <T> DoGroup<T> group(Iterable<T> items) {
		return group(New.stream(items));
	}

	public static <T> DoGroup<T> group(Stream<T> stream) {
		return new DoGroup<>(stream);
	}

	@SuppressWarnings("unchecked")
	public static <K, V> DoGroupBi<K, V> group(Map<K, V> items) {
		return new DoGroupBi<K, V>(items != null ? items : Collections.EMPTY_MAP);
	}

	public static <T> DoReduce<T> reduce(Iterable<T> items) {
		return reduce(New.stream(items));
	}

	public static <T> DoReduce<T> reduce(Stream<T> stream) {
		return new DoReduce<>(stream);
	}

}
