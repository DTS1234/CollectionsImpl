package uo.mp.collections.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class ContainsTests {

	private List list;
	private List listWithSeveralElements;
	private Object validObjectTest1;
	private Object validObjectTest2;
	private Object validObjectTest3;
	private Object validObjectTest4;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		listWithSeveralElements = Settings.factory.newList();
		validObjectTest1 = new String("testStringObject1");
		validObjectTest2 = new String("testStringObject2");
		validObjectTest3 = new String("testStringObject3");
		validObjectTest4 = new String("testStringObject4");
		
		listWithSeveralElements.add(validObjectTest2);
		listWithSeveralElements.add(validObjectTest3);
		listWithSeveralElements.add(validObjectTest4);
		
	}

	// GIVEN : contains invoked on empty list object
	// WHEN : calling contains method
	// THEN : returns false
	@Test
	public void emptyListTest() {

		assertFalse(list.contains(validObjectTest1));

	}

	// GIVEN : contains (element is not on the list) invoked on empty list object
	// WHEN : calling contains method
	// THEN : returns false
	@Test
	public void fullListNotContainsTest() {

		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.add(validObjectTest4);

		assertFalse(list.contains(validObjectTest1));

	}

	// GIVEN : contains (element is the list) invoked on list with one object
	// WHEN : calling contains method
	// THEN : returns false
	@Test
	public void listWithOneContainedTest() {

		list.add(validObjectTest1);
		assertTrue(list.contains(validObjectTest1));

	}

	// GIVEN : contains (elements are on the list) invoked on list with several
	// objects
	// WHEN : calling contains method
	// THEN : returns true
	@Test
	public void listWithOSeveralContainedTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);
		list.add(validObjectTest4);

		assertTrue(list.contains(validObjectTest2));
		assertTrue(list.contains(validObjectTest4));

	}

	// GIVEN : contains (elements are on the list) invoked on list with several
	// objects
	// WHEN : calling contains method
	// THEN : returns true
	@Test
	public void listWithOSeveralContainsNullTest() {

		assertFalse(list.contains(null));
		assertFalse(list.contains(null));

	}
	

	// GIVEN : contains (elements are on the list) invoked on empty list
	// objects
	// WHEN : calling contains method
	// THEN : returns true
	@Test
	public void listWithOEmptyListNullTest() {

		assertFalse(list.contains(null));

	}

}
