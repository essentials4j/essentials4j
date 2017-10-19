package org.essentials4j.utils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
public final class StreamUtils {

	private StreamUtils() {
	}

	public static <T, K, U> Collector<T, ?, Map<K, U>> toLinkedMap(Function<? super T, ? extends K> keyMapper,
	                                                               Function<? super T, ? extends U> valueMapper) {
		return Collectors.toMap(keyMapper, valueMapper, (oldValue, newValue) -> {
			throw new IllegalArgumentException(String.format("Duplicate key! Values are: %s and %s", oldValue, newValue));
		});
	}

	public static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> toLinkedMap() {
		return toLinkedMap(Map.Entry::getKey, Map.Entry::getValue);
	}

}
