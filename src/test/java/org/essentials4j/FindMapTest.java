/*-
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

package org.essentials4j;

import org.junit.Test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

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
		isTrue(Do.findIn(nums()).exists((k, v) -> k == 2));
		isFalse(Do.findIn(nums()).exists((k, v) -> k > 10));
	}

	@Test
	public void allOfWhere() {
		Map<Integer, String> notSmall = Do.findIn(nums()).all((k, v) -> k > 1);
		eq(notSmall, New.map(2, "two", 3, "three"));
	}

	@Test
	public void anyOfWhere() {
		Optional<Entry<Integer, String>> big = Do.findIn(nums()).any((k, v) -> v.length() == 5);
		eq(big.get(), 3, "three");
	}

	@Test
	public void lastOfWhere() {
		Optional<Entry<Integer, String>> anyBig = Do.findIn(nums()).last((k, v) -> v.length() > 4);
		eq(anyBig.get(), 3, "three");
	}

	@Test
	public void firstOfWhere() {
		Optional<Entry<Integer, String>> first = Do.findIn(nums()).first((k, v) -> k >= 2);
		eq(first.get(), 2, "two");
	}

}
