package org.essentials4j;

import org.essentials4j.dsl.*;

import java.util.Map;
import java.util.Objects;
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

	/* findIn */

	public static <T> FindDSL<T> findIn(Iterable<T> items) {
		Objects.requireNonNull(items);

		return findIn(New.stream(items));
	}

	public static <K, V> FindBiDSL<K, V> findIn(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new FindBiDSL<>(items);
	}

	public static <T> FindDSL<T> findIn(Stream<T> items) {
		Objects.requireNonNull(items);

		return new FindDSL<>(items);
	}

	/* map */

	public static <T> MapDSL<T> map(Iterable<T> items) {
		Objects.requireNonNull(items);

		return map(New.stream(items));
	}

	@SuppressWarnings("unchecked")
	public static <K, V> MapBiDSL<K, V> map(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new MapBiDSL<>(items);
	}

	public static <T> MapDSL<T> map(Stream<T> items) {
		Objects.requireNonNull(items);

		return new MapDSL<>(items);
	}

	/* group */

	public static <T> GroupDSL<T> group(Iterable<T> items) {
		Objects.requireNonNull(items);

		return group(New.stream(items));
	}

	@SuppressWarnings("unchecked")
	public static <K, V> GroupBiDSL<K, V> group(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new GroupBiDSL<>(items);
	}

	public static <T> GroupDSL<T> group(Stream<T> items) {
		Objects.requireNonNull(items);

		return new GroupDSL<>(items);
	}

}
