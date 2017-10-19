package org.essentials4j.find;

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

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class FindAll<T> {

	private final Stream<T> stream;

	public FindAll(Stream<T> stream) {
		this.stream = stream;
	}

	public List<T> where(Predicate<? super T> predicate) {
		return stream.filter(predicate).collect(Collectors.toList());
	}

}
