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
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class FindDSL<T> {

	private final Stream<T> stream;

	public FindDSL(Stream<T> stream) {
		this.stream = stream;
	}

	/**
	 * Searches through the pre-specified items for the existence of any element that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function
	 * @return {@code true} if any matching element has been found, or {@code false} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public boolean exists(Predicate<? super T> predicate) {
		return stream.anyMatch(predicate);
	}

	/**
	 * Searches through the pre-specified items for the first element that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function
	 * @return {@code Optional} wrapping the first matching element if it has been found, or an empty {@code Optional} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public Optional<T> first(Predicate<? super T> predicate) {
		return stream.filter(predicate)
			.findFirst();
	}

	/**
	 * Searches through the pre-specified items for the last element that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function
	 * @return {@code Optional} wrapping the last matching element if it has been found, or an empty {@code Optional} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public Optional<T> last(Predicate<? super T> predicate) {
		return stream.filter(predicate)
			.reduce((prev, next) -> next);
	}

	/**
	 * Searches through the pre-specified items for any element that satisfies the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function
	 * @return {@code Optional} wrapping any matching element if it has been found, or an empty {@code Optional} otherwise
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public Optional<T> any(Predicate<? super T> predicate) {
		return stream.filter(predicate)
			.findAny();
	}

	/**
	 * Searches through the pre-specified items for all elements that satisfy the specified criteria (predicate).
	 *
	 * @param predicate the search criteria specified as a predicate function
	 * @return a new {@code List} consisting of all matching elements that have been found, if any
	 * @throws NullPointerException if {@code predicate} is {@code null}
	 */
	public List<T> all(Predicate<? super T> predicate) {
		return stream.filter(predicate)
			.collect(To.list());
	}

}
