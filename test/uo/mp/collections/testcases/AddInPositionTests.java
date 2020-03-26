package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class AddInPositionTests {

	private List list;
	private List listWithFewElements;
	private Object validObjectTest1;
	private Object validObjectTest2;
	private Object validObjectTest3;
	private Object validObjectTest4;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		listWithFewElements = Settings.factory.newList();
		
		validObjectTest1 = new String("1");
		validObjectTest2 = new String("2");
		validObjectTest3 = new String("3");
		validObjectTest4 = new String("4");
		
		listWithFewElements.add(validObjectTest2);
		listWithFewElements.add(validObjectTest3);
		listWithFewElements.add(validObjectTest4);

		
	}

	// GIVEN : add (method with null element parameter) invoked on list object
	// WHEN : calling add method
	// THEN : throws IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void addNullValueTest() {
		listWithFewElements.add(1, null);
	}

	// GIVEN : add (method with negative index parameter) invoked on list object
	// WHEN : calling add method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void addAtNegativeIndexTest() {
		list.add(-1, validObjectTest1);
	}

	// GIVEN : add (method with greater than size index parameter) invoked on list
	// object
	// WHEN : calling add method
	// THEN : throws IndexOutOfBoundsException
	@Test(expected = IndexOutOfBoundsException.class)
	public void addAtGreaterThanListSizeIndexTest() {
		list.add(1000, validObjectTest1);
	}

	// GIVEN : add (method with valid index and element parameters) invoked on list
	// object
	// WHEN : calling add method
	// THEN : adds element and moves rest to the right
	@Test
	public void addIntermediateValidParameters() {

		listWithFewElements.add(1, validObjectTest1);
		
		assertEquals(4, listWithFewElements.size());
		assertEquals(validObjectTest1, listWithFewElements.get(1));
		assertEquals(validObjectTest3, listWithFewElements.get(2));
		assertEquals(validObjectTest4, listWithFewElements.get(3));
		assertEquals(validObjectTest2, listWithFewElements.get(0));

	}

	// GIVEN : add (at index 0) invoked on empty list object
	// WHEN : calling add method
	// THEN : added at index 0
	@Test
	public void addAtZeroIndexToEmptyListTest() {
		list.add(0, validObjectTest1);

		assertEquals(1, list.size());
		assertEquals(validObjectTest1, list.get(0));

	}

	// GIVEN : add (at index 0) invoked on full list object
	// WHEN : calling add method
	// THEN : element added at index 0 and moves rest items to the right
	@Test
	public void addAtZeroIndexToFullList() {

		listWithFewElements.add(0, validObjectTest1);

		assertEquals(validObjectTest1, listWithFewElements.get(0));
		assertEquals(validObjectTest2, listWithFewElements.get(1));
		assertEquals(validObjectTest3, listWithFewElements.get(2));
		assertEquals(validObjectTest4, listWithFewElements.get(3));

	}

	// GIVEN : add (at last index) invoked on full list object
	// WHEN : calling add method
	// THEN : element added at last index
	@Test
	public void addAtLastIndexToFullList() {

		listWithFewElements.add(2, validObjectTest1);

		assertEquals(validObjectTest1, listWithFewElements.get(2));

	}

	// GIVEN : add (at last index) invoked on full list object
	// WHEN : calling add method
	// THEN : element added to the end of the list
	@Test
	public void addAtListSizeIndexToFullList() {
		
		listWithFewElements.add(3, validObjectTest1);

		assertEquals(validObjectTest1, listWithFewElements.get(3));

	}

}
