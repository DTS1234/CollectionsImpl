package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class GetTests {

	private List list;
	private Object validObjectTest1;
	private Object validObjectTest2;
	private Object validObjectTest3;
	private Object validObjectTest4;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		validObjectTest1 = new Object();
		validObjectTest2 = new Object();
		validObjectTest3 = new Object();
		validObjectTest4 = new Object();

	}

	// GIVEN : get invoked on full list
	// WHEN : calling get method
	// THEN : returns element by index
	@Test
	public void getElementTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.add(validObjectTest4);

		assertEquals(validObjectTest1, list.get(0));
		assertEquals(validObjectTest2, list.get(1));
		assertEquals(validObjectTest3, list.get(2));
		assertEquals(validObjectTest4, list.get(3));

	}

	// GIVEN : get invoked on empty list
	// WHEN : calling get method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void getZeroElementFromEmptyListTest() {

		list.get(0);

	}

	// GIVEN : get with -1 index invoked on empty list
	// WHEN : calling get method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void getNegativeElementFromEmptyListTest() {

		list.get(-1);

	}

	// GIVEN : get with -1 index invoked on full list
	// WHEN : calling get method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void getNegativeElementFromFullListTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.add(validObjectTest4);

		list.get(-1);

	}

	// GIVEN : get with -1 index invoked on full list
	// WHEN : calling get method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void getSizeElementFromFullListTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.add(validObjectTest4);

		list.get(list.size());

	}

}
