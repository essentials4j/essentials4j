package org.essentials4j;

import org.essentials4j.find.*;

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
public final class Find {

	private Find() {
	}

	/* firstOf */

	public static <T> FindFirst<T> firstOf(Iterable<T> items) {
		Objects.requireNonNull(items);

		return firstOf(New.stream(items));
	}

	public static <K, V> FindFirstBi<K, V> firstOf(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new FindFirstBi<>(items);
	}

	public static <T> FindFirst<T> firstOf(Stream<T> stream) {
		Objects.requireNonNull(stream);

		return new FindFirst<>(stream);
	}

	/* allOf */

	public static <T> FindAll<T> allOf(Iterable<T> items) {
		Objects.requireNonNull(items);

		return allOf(New.stream(items));
	}

	public static <K, V> FindAllBi<K, V> allOf(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new FindAllBi<>(items);
	}

	public static <T> FindAll<T> allOf(Stream<T> stream) {
		Objects.requireNonNull(stream);

		return new FindAll<>(stream);
	}

	/* anyOf */

	public static <T> FindAny<T> anyOf(Iterable<T> items) {
		Objects.requireNonNull(items);

		return anyOf(New.stream(items));
	}

	public static <K, V> FindAnyBi<K, V> anyOf(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new FindAnyBi<>(items);
	}

	public static <T> FindAny<T> anyOf(Stream<T> stream) {
		Objects.requireNonNull(stream);

		return new FindAny<>(stream);
	}

	/* lastOf */

	public static <T> FindLast<T> lastOf(Iterable<T> items) {
		Objects.requireNonNull(items);

		return lastOf(New.stream(items));
	}

	public static <K, V> FindLastBi<K, V> lastOf(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new FindLastBi<>(items);
	}

	public static <T> FindLast<T> lastOf(Stream<T> stream) {
		Objects.requireNonNull(stream);

		return new FindLast<>(stream);
	}

	/* in */

	public static <T> FindIn<T> in(Iterable<T> items) {
		Objects.requireNonNull(items);

		return in(New.stream(items));
	}

	public static <K, V> FindInBi<K, V> in(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new FindInBi<>(items);
	}

	public static <T> FindIn<T> in(Stream<T> stream) {
		Objects.requireNonNull(stream);

		return new FindIn<>(stream);
	}

}
