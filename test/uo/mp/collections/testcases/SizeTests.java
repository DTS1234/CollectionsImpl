package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class SizeTests {

	private List list;
	private Object validObjectTest1;
	private Object validObjectTest2;
	private Object validObjectTest3;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		validObjectTest1 = new Object();
		validObjectTest2 = new Object();
		validObjectTest3 = new Object();
	}

	// GIVEN : empty list
	// WHEN : calling size() method
	// THEN : 0 returned
	@Test
	public void emptyListTest() {
		assertEquals(0, list.size());
	}

	// GIVEN : one element list
	// WHEN : calling size() method
	// THEN : 1 returned
	@Test
	public void oneElementListTest() {
		list.add(validObjectTest1);
		assertEquals(1, list.size());
	}

	// GIVEN : three element list
	// WHEN : calling size() method
	// THEN : returned
	@Test
	public void severalElementsListTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertEquals(3, list.size());
	}

	// GIVEN : empty list added element
	// WHEN : calling size() method
	// THEN : 1 returned
	@Test
	public void increaseSizeTest() {

		list.add(validObjectTest1);

		assertEquals(1, list.size());
	}

	// GIVEN : list after element removal
	// WHEN : calling size() method
	// THEN : 0 returned
	@Test
	public void decreaseSizeTest() {

		list.add(validObjectTest1);
		list.remove(0);

		assertEquals(0, list.size());

	}

}
