package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;
import uo.mp.collections.setting.Settings;

public class IndexOfTests {

	private List list = new LinkedList();
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

	// GIVEN : non existing on list object passed
	// WHEN : calling indexOf() method
	// THEN : returns -1
	@Test
	public void nonExistingTest() {
		assertEquals(-1, list.indexOf(validObjectTest1));
	}

	// GIVEN : null object passed
	// WHEN : calling indexOf() method
	// THEN : returns -1
	@Test
	public void nullTest() {
		assertEquals(-1, list.indexOf(null));
	}

	// GIVEN : correct objects passed
	// WHEN : calling indexOf() method
	// THEN : returns valid index
	@Test
	public void correctIndexTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertEquals(list.indexOf(validObjectTest1), 0);
		assertEquals(list.indexOf(validObjectTest2), 1);
		assertEquals(list.indexOf(validObjectTest3), 2);

	}

	// GIVEN : repeated object passed
	// WHEN : calling indexOf() method
	// THEN : returns first occurrence index 
	@Test
	public void correctRepeatedIndexTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest1);

		assertEquals(list.indexOf(validObjectTest1), 0);

	}

}
