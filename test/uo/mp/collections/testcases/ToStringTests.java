package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class ToStringTests {

	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	// GIVEN : empty list
	// WHEN : calling toString() method
	// THEN : "[]" returned
	@Test
	public void emptyListTest() {
		assertEquals("[]", list.toString());
	}

	// GIVEN : one element list
	// WHEN : calling toString() method
	// THEN : "[A]" returned
	@Test
	public void oneElementListTest() {
		list.add("A");
		assertEquals("[A]", list.toString());
	}

	// GIVEN : two elements List
	// WHEN : calling toString() method
	// THEN : "[A, B]" returned
	@Test
	public void twoElementListTest() {
		list.add("A");
		list.add("B");
		assertEquals("[A, B]", list.toString());
	}

}
