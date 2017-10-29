package org.essentials4j;

import org.junit.Test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

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
public class FindMapTest extends TestCommons {

	private Map<Integer, String> nums() {
		return New.map(1, "one", 2, "two", 3, "three");
	}

	@Test
	public void inExists() {
		isTrue(Find.in(nums()).exists((k, v) -> k == 2));
		isFalse(Find.in(nums()).exists((k, v) -> k > 10));
	}

	@Test
	public void allOfWhere() {
		Map<Integer, String> notSmall = Find.allOf(nums()).where((k, v) -> k > 1);
		eq(notSmall, New.map(2, "two", 3, "three"));
	}

	@Test
	public void anyOfWhere() {
		Optional<Entry<Integer, String>> big = Find.anyOf(nums()).where((k, v) -> v.length() == 5);
		eq(big.get(), 3, "three");
	}

	@Test
	public void lastOfWhere() {
		Optional<Entry<Integer, String>> anyBig = Find.lastOf(nums()).where((k, v) -> v.length() > 4);
		eq(anyBig.get(), 3, "three");
	}

	@Test
	public void firstOfWhere() {
		Optional<Entry<Integer, String>> first = Find.firstOf(nums()).where((k, v) -> k >= 2);
		eq(first.get(), 2, "two");
	}

}