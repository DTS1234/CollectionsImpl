package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class AddLastTests {

	private List list;
	private Object validObjectTest1;
	private Object validObjectTest1Copy;
	private Object validObjectTest2;
	private Object validObjectTest3;
	private Object validObjectTest4;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		validObjectTest1 = new String("testStringObject1");
		validObjectTest1Copy = new String("testStringObject1");
		validObjectTest2 = new String("testStringObject2");
		validObjectTest3 = new String("testStringObject3");
		validObjectTest4 = new String("testStringObject4");
	}

	// GIVEN : add invoked on empty list object
	// WHEN : calling add method
	// THEN : adds element and returns true
	@Test
	public void addEmptyListTest() {

		assertTrue(list.add(validObjectTest1));
		assertEquals(1, list.size());

	}

	// GIVEN : add invoked on full list object
	// WHEN : calling add method
	// THEN : adds element to the end of the list and returns true
	@Test
	public void addFullListTest() {

		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.add(validObjectTest4);

		assertTrue(list.add(validObjectTest1));
		assertEquals(4, list.size());
		assertEquals(validObjectTest1, list.get(3));

	}

	// GIVEN : add invoked on cleared list object
	// WHEN : calling add method
	// THEN : adds element to the first position and returns true
	@Test
	public void addToClearedListTest() {

		list.clear();

		assertTrue(list.add(validObjectTest1));
		assertEquals(validObjectTest1, list.get(0));
		assertEquals(1, list.size());

	}

	// GIVEN : add (same elements) invoked on list object
	// WHEN : calling add method
	// THEN : returns true
	@Test
	public void addRepeatedElementTest() {
		
		assertTrue(list.add(validObjectTest1));
		assertTrue(list.add(validObjectTest1Copy));
		assertEquals(validObjectTest1, list.get(0));
		assertEquals(validObjectTest1Copy, list.get(1));
		assertEquals(2, list.size());

	}

	// GIVEN : add (method with null element parameter) invoked on list object
	// WHEN : calling add method
	// THEN : throws IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void addNullValueTest() {
		list.add(null);
	}

	// GIVEN : add (method with index parameter) invoked on list object
	// WHEN : calling add method
	// THEN : throws IndexOutOfBoundsException
	@Test
	public void addWithValidParameters() {
		list.add(0, validObjectTest1);
		list.add(1, validObjectTest2);
		list.add(2, validObjectTest3);
		
		list.add(validObjectTest4);

		assertEquals(4, list.size());
		assertEquals(validObjectTest1, list.get(0));
		assertEquals(validObjectTest3, list.get(2));
		assertEquals(validObjectTest4, list.get(3));
		assertEquals(validObjectTest2, list.get(1));

	}

}
