package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class RemoveFromPositionTests {

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

	// GIVEN : one element list
	// WHEN : calling remove() method
	// THEN : element removed list is empty
	@Test
	public void removeZeroOneElemPositionTest() {

		list.add(validObjectTest1);

		assertEquals(list.remove(0), validObjectTest1);
		assertTrue(list.isEmpty());

	}

	// GIVEN : several elements list
	// WHEN : calling remove(0) method
	// THEN : element removed, list is not empty
	@Test
	public void removeZeroFullPositionTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);

		assertEquals(list.remove(0), validObjectTest1);
		assertTrue(list.contains(validObjectTest1)==false);
		assertEquals(list.indexOf(validObjectTest2), 0);

	}

	// GIVEN : removing correct element from list
	// WHEN : calling remove() method
	// THEN : element removed, items repositioned
	@Test
	public void removeExistingPositionTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertEquals(list.remove(1), validObjectTest2);
		assertTrue(!list.contains(validObjectTest2));
		assertTrue(list.indexOf(validObjectTest3) == 1);

	}

	// GIVEN : removing last element from list
	// WHEN : calling remove() method
	// THEN : element removed
	@Test
	public void removeLastPositionTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertEquals(list.remove(2), validObjectTest3);
		assertTrue(list.contains(validObjectTest3)==false);

	}

	// GIVEN : removing negative by index from list
	// WHEN : calling remove() method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeNegatvieTest() {

		list.remove(-1);

	}

	// GIVEN : removing form empty list
	// WHEN : calling remove() method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeEmptyTest() {

		list.remove(0);

	}

	// GIVEN : removing size index from empty list
	// WHEN : calling remove() method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeEmptySizePostionTest() {

		list.remove(list.size());

	}

	// GIVEN : removing size index from full list
	// WHEN : calling remove() method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFullSizePostionTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		list.remove(list.size());

	}

}
