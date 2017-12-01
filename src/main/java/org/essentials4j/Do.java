package org.essentials4j;

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

	/**
	 * Static utilities. Do not instantiate.
	 */
	private Do() {
	}

	/* findIn */

	/**
	 * Searches through the specified items for elements that satisfy the criteria that will be specified.
	 * <p>
	 * The search will be executed as soon as the search criteria is specified as predicate through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.findIn(items).exists(item -> criteria)
	 * Do.findIn(items).first(item -> criteria)
	 * Do.findIn(items).last(item -> criteria)
	 * Do.findIn(items).any(item -> criteria)
	 * Do.findIn(items).all(item -> criteria)
	 * </code></pre>
	 *
	 * @param items the items to search through
	 * @return DSL helper used to specify search criteria and execute the search through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <T> FindDSL<T> findIn(Iterable<T> items) {
		Objects.requireNonNull(items);

		return findIn(New.stream(items));
	}

	/**
	 * Searches through the specified items for {@code Map} entries that satisfy the criteria that will be specified.
	 * <p>
	 * The search will be executed as soon as the search criteria is specified as predicate through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.findIn(items).exists((key, value) -> criteria)
	 * Do.findIn(items).first((key, value) -> criteria)
	 * Do.findIn(items).last((key, value) -> criteria)
	 * Do.findIn(items).any((key, value) -> criteria)
	 * Do.findIn(items).all((key, value) -> criteria)
	 * </code></pre>
	 *
	 * @param items the items to search through
	 * @return DSL helper used to specify search criteria and execute the search through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <K, V> FindBiDSL<K, V> findIn(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new FindBiDSL<>(items);
	}

	/**
	 * Searches through the specified items for elements that satisfy the criteria that will be specified.
	 * <p>
	 * The search will be executed as soon as the search criteria is specified as predicate through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.findIn(items).exists(item -> criteria)
	 * Do.findIn(items).first(item -> criteria)
	 * Do.findIn(items).last(item -> criteria)
	 * Do.findIn(items).any(item -> criteria)
	 * Do.findIn(items).all(item -> criteria)
	 * </code></pre>
	 *
	 * @param items the items to search through
	 * @return DSL helper used to specify search criteria and execute the search through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <T> FindDSL<T> findIn(Stream<T> items) {
		Objects.requireNonNull(items);

		return new FindDSL<>(items);
	}

	/* map */

	/**
	 * Maps (transforms) the specified items by applying the transformation function that will be specified.
	 * <p>
	 * The mapping will be executed as soon as the transformation function is specified through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.map(items).toList(item -> transformation)
	 * Do.map(items).toSet(item -> transformation)
	 * Do.map(items).toMap(item -> transformation)
	 * </code></pre>
	 *
	 * @param items the items to map (transform)
	 * @return DSL helper used to specify transformation function and execute the mapping through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <T> MapDSL<T> map(Iterable<T> items) {
		Objects.requireNonNull(items);

		return map(New.stream(items));
	}

	/**
	 * Maps (transforms) the specified items by applying the transformation function that will be specified.
	 * <p>
	 * The mapping will be executed as soon as the transformation function is specified through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.map(items).toList((key, value) -> transformation)
	 * Do.map(items).toSet((key, value) -> transformation)
	 * Do.map(items).toMap((key, value) -> transformation)
	 * </code></pre>
	 *
	 * @param items the items to map (transform)
	 * @return DSL helper used to specify transformation function and execute the mapping through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <K, V> MapBiDSL<K, V> map(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new MapBiDSL<>(items);
	}

	/**
	 * Maps (transforms) the specified items by applying the transformation function that will be specified.
	 * <p>
	 * The mapping will be executed as soon as the transformation function is specified through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.map(items).toList(item -> transformation)
	 * Do.map(items).toSet(item -> transformation)
	 * Do.map(items).toMap(item -> transformation)
	 * </code></pre>
	 *
	 * @param items the items to map (transform)
	 * @return DSL helper used to specify transformation function and execute the mapping through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <T> MapDSL<T> map(Stream<T> items) {
		Objects.requireNonNull(items);

		return new MapDSL<>(items);
	}

	/* group */

	/**
	 * Groups the specified items according to a classification function that will be specified.
	 * <p>
	 * The grouping will be executed as soon as the classification function is specified through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.group(items).by(item -> classifier)
	 * </code></pre>
	 *
	 * @param items the items to group
	 * @return DSL helper used to specify classification function and execute the grouping through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <T> GroupDSL<T> group(Iterable<T> items) {
		Objects.requireNonNull(items);

		return group(New.stream(items));
	}

	/**
	 * Groups the specified items according to a classification function that will be specified.
	 * <p>
	 * The grouping will be executed as soon as the classification function is specified through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.group(items).by((key, value) -> classifier)
	 * </code></pre>
	 *
	 * @param items the items to group
	 * @return DSL helper used to specify classification function and execute the grouping through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <K, V> GroupBiDSL<K, V> group(Map<K, V> items) {
		Objects.requireNonNull(items);

		return new GroupBiDSL<>(items);
	}

	/**
	 * Groups the specified items according to a classification function that will be specified.
	 * <p>
	 * The grouping will be executed as soon as the classification function is specified through method chain call.
	 * <p> Usage:
	 * <pre><code>
	 * Do.group(items).by(item -> classifier)
	 * </code></pre>
	 *
	 * @param items the items to group
	 * @return DSL helper used to specify classification function and execute the grouping through method chain call
	 * @throws NullPointerException if {@code items} is {@code null}
	 */
	public static <T> GroupDSL<T> group(Stream<T> items) {
		Objects.requireNonNull(items);

		return new GroupDSL<>(items);
	}

}
