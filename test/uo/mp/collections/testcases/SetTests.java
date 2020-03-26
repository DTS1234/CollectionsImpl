package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class SetTests {

	private List list;
	private Object validObjectTest1;
	private Object validObjectTest2;
	private Object validObjectTest3;
	private Object validObjectTest4;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		validObjectTest1 = new String("String 1");
		validObjectTest2 = new String("String 3");
		validObjectTest3 = new String("String 2");
		validObjectTest4 = new String("String 4");
	}

	// GIVEN : one element list
	// WHEN : calling set() method
	// THEN : element set and previous element returned
	@Test
	public void setZeroPositionTest() {

		list.add(validObjectTest1);
		assertEquals(validObjectTest1, list.set(0, validObjectTest2));
		assertTrue(list.get(0).equals(validObjectTest2));

	}

	// GIVEN : several elements list
	// WHEN : calling set() method
	// THEN : element set and previous element returned
	@Test
	public void setNPositionTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertEquals(validObjectTest2, list.set(1, validObjectTest4));
		assertEquals(list.get(1), (validObjectTest4));

	}

	// GIVEN : several elements list
	// WHEN : calling set() method
	// THEN : element set and previous element returned
	@Test
	public void setFinalPositionTest() {
		
		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);
		
		assertEquals(validObjectTest3, list.set(2, validObjectTest4));
		assertEquals(list.get(2).toString(), (validObjectTest4).toString());
		
	}

	// GIVEN : empty list set with zero parameter called
	// WHEN : calling set() method
	// THEN : IndexOutOfBoundsException.class thrown
	@Test(expected = IndexOutOfBoundsException.class)
	public void setZeroPositionEmptyListTest() {

		list.set(0, validObjectTest1);

	}

	// GIVEN : empty list set with negative parameter called
	// WHEN : calling set() method
	// THEN : IndexOutOfBoundsException.class thrown
	@Test(expected = IndexOutOfBoundsException.class)
	public void setNegativePositionEmptyListTest() {

		list.set(-1, validObjectTest1);

	}

	// GIVEN : full list set with negative parameter called
	// WHEN : calling set() method
	// THEN : IndexOutOfBoundsException.class thrown
	@Test(expected = IndexOutOfBoundsException.class)
	public void setNegativePositionFullListTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.set(-1, validObjectTest1);

	}

	// GIVEN : full list set with size() parameter called
	// WHEN : calling set() method
	// THEN : IndexOutOfBoundsException.class thrown
	@Test(expected = IndexOutOfBoundsException.class)
	public void setSizePositionFullListTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.set(list.size(), validObjectTest1);

	}

	// GIVEN : empty list set with size parameter called
	// WHEN : calling set() method
	// THEN : IndexOutOfBoundsException.class thrown
	@Test(expected = IndexOutOfBoundsException.class)
	public void setSizePositionEmptyListTest() {

		list.set(list.size(), validObjectTest1);

	}

}
