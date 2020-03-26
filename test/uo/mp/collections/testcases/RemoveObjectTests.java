package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class RemoveObjectTests {

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
	public void oneElementRemoveTest() {

		list.add(validObjectTest1);
		assertEquals(true, list.remove(validObjectTest1));
		assertTrue(list.isEmpty());

	}

	// GIVEN : few elements list
	// WHEN : calling remove() method
	// THEN : element removed list not empty
	@Test
	public void severalElementsRemoveTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertEquals(true, list.remove(validObjectTest1));
		assertTrue(!list.isEmpty());

	}

	// GIVEN : list empty and trying to remove non exsiting element
	// WHEN : calling remove() method
	// THEN : false returned
	@Test
	public void emptyNonexsistingListRemoveTest() {

		assertEquals(false, list.remove(validObjectTest1));

	}

	// GIVEN : several items on list and trying to remove non exsiting element
	// WHEN : calling remove() method
	// THEN : false returned
	@Test
	public void fullNonExsistingListRemoveTest() {

		list.add(validObjectTest2);
		list.add(validObjectTest3);

		assertEquals(false, list.remove(validObjectTest1));
		assertEquals(2, list.size());

	}

	// GIVEN : list with repeated elements
	// WHEN : calling remove() method
	// THEN : first occurrence removed and returned true
	@Test
	public void RepeatedElementListRemoveTest() {

		list.add(validObjectTest1);
		list.add(validObjectTest1);

		assertEquals(true, list.remove(validObjectTest1));

	}

	// GIVEN : trying to remove null
	// WHEN : calling remove
	// THEN : returns false
	@Test
	public void NullRemoveTest() {

		assertEquals(false, list.remove(null));

	}

}
