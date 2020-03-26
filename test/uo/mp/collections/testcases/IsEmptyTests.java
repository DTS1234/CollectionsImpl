package uo.mp.collections.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class IsEmptyTests {

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
	// WHEN : calling isEmpty() method
	// THEN : returns true
	@Test
	public void newListTest() {
		assertTrue(list.isEmpty());
	}

	// GIVEN : cleared list
	// WHEN : calling isEmpty() method
	// THEN : returns true
	@Test
	public void clearedListTest() {

		list.add(validObjectTest1);
		list.clear();

		assertTrue(list.isEmpty());
	}

	// GIVEN : one element list
	// WHEN : calling isEmpty() method
	// THEN : returns false
	@Test
	public void oneElementListTest() {

		list.add(validObjectTest1);

		assertFalse(list.isEmpty());

	}

	// GIVEN : few elements on list
	// WHEN : calling isEmpty() method
	// THEN : returns false
	@Test
	public void severalElementsListTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertFalse(list.isEmpty());

	}

}
