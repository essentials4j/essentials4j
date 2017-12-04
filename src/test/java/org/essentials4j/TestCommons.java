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

import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Common test helpers.
 *
 * @author Nikolche Mihajlovski
 * @since 1.0.0
 */
public abstract class TestCommons {

	protected void notNull(Object value) {
		try {
			Assert.assertNotNull(value);
		} catch (AssertionError e) {

			throw e;
		}
	}

	protected void isTrue(boolean cond) {
		try {
			Assert.assertTrue(cond);
		} catch (AssertionError e) {

			throw e;
		}
	}

	protected void isFalse(boolean cond) {
		try {
			Assert.assertFalse(cond);
		} catch (AssertionError e) {

			throw e;
		}
	}

	protected void eq(Object actual, Object expected) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError e) {

			throw e;
		}
	}

	protected void eq(String actual, String expected) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError e) {

			throw e;
		}
	}

	protected void eq(long actual, long expected) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError e) {

			throw e;
		}
	}

	protected <K, V> void eq(Entry<K, V> actual, K expectedKey, V expectedValue) {
		eq(actual.getKey(), expectedKey);
		eq(actual.getValue(), expectedValue);
	}

	protected <K, V> void expectMap(Map<K, V> actual, Map<K, V> expected) {
		notNull(actual);
		isTrue(actual instanceof LinkedHashMap);
		eq(actual, expected);
	}

}
