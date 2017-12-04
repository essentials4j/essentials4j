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

import java.util.List;
import java.util.Optional;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class FindCollTest extends TestCommons {

	private List<String> abc() {
		return New.list("a", "bbbbb", "cc");
	}

	@Test
	public void inExists() {
		isTrue(Do.findIn(abc()).exists(s -> s.length() < 5));
		isFalse(Do.findIn(abc().stream()).exists(s -> s.length() > 10));
	}

	@Test
	public void allOfWhere() {
		List<String> notSmall = Do.findIn(abc()).all(s -> s.length() > 1);
		eq(notSmall, New.list("bbbbb", "cc"));
	}

	@Test
	public void anyOfWhere() {
		Optional<String> big = Do.findIn(abc()).any(s -> s.length() == 5);
		eq(big.get(), "bbbbb");
	}

	@Test
	public void lastOfWhere() {
		Optional<String> anyBig = Do.findIn(abc()).last(s -> s.length() > 4);
		eq(anyBig.get(), "bbbbb");
	}

	@Test
	public void firstOfWhere() {
		Optional<String> firstSmall = Do.findIn(abc()).first(s -> s.length() < 3);
		eq(firstSmall.get(), "a");
	}

}
