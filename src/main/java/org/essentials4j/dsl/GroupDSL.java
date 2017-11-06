package org.essentials4j.dsl;

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

import org.essentials4j.New;
import org.essentials4j.To;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class GroupDSL<T> {

	private final Stream<T> stream;

	public GroupDSL(Stream<T> stream) {
		this.stream = stream;
	}

	/**
	 * Groups the pre-specified items according to the specified classification function, which maps each element to a classification key.
	 * <p>
	 * The resulting groups of elements are stored into a new {@code Map} with the following structure:
	 * <p>
	 * - keys: the distinct set of classification keys,
	 * <p>
	 * - values: for each classification key, a {@code List} of all elements that were mapped to that key.
	 *
	 * @param classifier the classification function used to group the items
	 * @return a new {@code Map} consisting of the grouped items
	 * @throws NullPointerException if {@code classifier} is {@code null}
	 */
	public <K> Map<K, List<T>> by(Function<T, K> classifier) {
		return stream.collect(Collectors.groupingBy(classifier, New::map, To.list()));
	}

}
