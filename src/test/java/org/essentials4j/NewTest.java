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
import java.util.Map;
import java.util.Set;

/**
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public class NewTest extends TestCommons {

	@Test
	public void testEmptySet() {
		Set<Integer> set = New.set();

		isTrue(set.isEmpty());
	}

	@Test
	public void testSet() {
		Set<Integer> set = New.set(1, 3, 5, 8);

		eq((set.size()), 4);

		isTrue(set.contains(1));
		isTrue(set.contains(3));
		isTrue(set.contains(5));
		isTrue(set.contains(8));
	}

	@Test
	public void testNestedConstruction() {
		List<String> list = New.list(New.set(New.list("foo", "bar", "bar", "baz", "foo")));

		eq((list.size()), 3);

		eq((list.get(0)), "foo");
		eq((list.get(1)), "bar");
		eq((list.get(2)), "baz");
	}

	@Test
	public void testEmptyList() {
		List<String> list = New.list();

		isTrue(list.isEmpty());
	}

	@Test
	public void testList() {
		List<String> list = New.list("m", "k", "l");

		eq((list.size()), 3);

		eq((list.get(0)), "m");
		eq((list.get(1)), "k");
		eq((list.get(2)), "l");
	}

	@Test
	public void testEmptyMap() {
		Map<String, Integer> map = New.map();

		isTrue((map.isEmpty()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMapArgs() {
		New.map("key without value");
	}

	@Test
	public void testMapFromMap() {
		Map<String, Integer> map = New.map(New.map(New.map("a", 1, "b", 2)));

		eq((map.size()), 2);

		eq((map.get("a").intValue()), 1);
		eq((map.get("b").intValue()), 2);
	}

	@Test
	public void testMap1KV() {
		Map<String, Integer> map = New.map("a", 1);

		eq((map.size()), 1);

		eq((map.get("a").intValue()), 1);
	}

	@Test
	public void testMap2KV() {
		Map<String, Integer> map = New.map("a", 1, "b", 2);

		eq((map.size()), 2);

		eq((map.get("a").intValue()), 1);
		eq((map.get("b").intValue()), 2);
	}

	@Test
	public void testMap3KV() {
		Map<String, Integer> map = New.map("a", 1, "b", 2, "c", 3);

		eq((map.size()), 3);

		eq((map.get("a").intValue()), 1);
		eq((map.get("b").intValue()), 2);
		eq((map.get("c").intValue()), 3);
	}

	@Test
	public void testMap4KV() {
		Map<String, Integer> map = New.map("a", 1, "b", 2, "c", 3, "d", 4);

		eq((map.size()), 4);

		eq((map.get("a").intValue()), 1);
		eq((map.get("b").intValue()), 2);
		eq((map.get("c").intValue()), 3);
		eq((map.get("d").intValue()), 4);
	}

	@Test
	public void testMap5KV() {
		Map<String, Integer> map = New.map("a", 1, "b", 2, "c", 3, "d", 4, "e", 5);

		eq((map.size()), 5);

		eq((map.get("a").intValue()), 1);
		eq((map.get("b").intValue()), 2);
		eq((map.get("c").intValue()), 3);
		eq((map.get("d").intValue()), 4);
		eq((map.get("e").intValue()), 5);
	}

	@Test
	public void testMapAnyKV() {
		Map<String, Integer> map = New.map("a", 1, "b", 2, "c", 3, "d", 4, "e", 5, "f", 6, "g", 7, "h", 8);

		eq((map.size()), 8);

		eq((map.get("a").intValue()), 1);
		eq((map.get("b").intValue()), 2);
		eq((map.get("c").intValue()), 3);
		eq((map.get("d").intValue()), 4);
		eq((map.get("e").intValue()), 5);
		eq((map.get("f").intValue()), 6);
		eq((map.get("g").intValue()), 7);
		eq((map.get("h").intValue()), 8);
	}

}
