package org.essentials4j;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class DoCollTest extends TestCommons {

	private List<String> abc() {
		return New.list("a", "bbbbb", "cc");
	}

	@Test
	public void doMapToList() {
		List<Integer> lengths2 = Do.map(abc()).toList(String::length);
		eq(lengths2, New.list(1, 5, 2));
	}

	@Test
	public void listToMap() {
		Map<String, Integer> lengthsByWord = Do.map(abc()).toMap(s -> s, String::length);
		expectMap(lengthsByWord, New.map("a", 1, "bbbbb", 5, "cc", 2));
	}

	@Test
	public void listToMapConflicting() {
		List<String> letters = New.list("a", "bb", "c");

		try {
			Do.map(letters).toMap(String::length, s -> s);

		} catch (IllegalArgumentException e) {
			// this is expected
			eq(e.getMessage(), "Both values [a] and [c] have the same key!");
			return;
		}

		Assert.fail("Expected IllegalArgumentException!");
	}

	@Test
	public void groupListBy() {
		Map<Integer, List<String>> byLengths = Do.group(abc()).by(String::length);
		expectMap(byLengths, New.map(1, New.list("a"), 5, New.list("bbbbb"), 2, New.list("cc")));
	}

	@Test
	public void listToSet() {
		Set<Integer> lengths3 = Do.map(abc()).toSet(String::length);
		eq(lengths3, New.set(1, 2, 5));
	}

}
