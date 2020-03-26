package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;

public class EqualsTests {

	private List testArrayList1;
	private List testArrayList2;
	private List testLinkedList1;
	private List testLinkedList2;

	private Object validObjectTest2;
	private Object validObjectTest3;
	private Object validObjectTest4;

	@Before
	public void setUp() throws Exception {

		testArrayList1 = new ArrayList();
		testArrayList2 = new ArrayList();
		testLinkedList1 = new LinkedList();
		testLinkedList2 = new LinkedList();

		validObjectTest2 = new String("testStringObject2");
		validObjectTest3 = new String("testStringObject3");
		validObjectTest4 = new String("testStringObject4");

	}

	// GIVEN : two empty LinkedLists
	// WHEN : calling equals method
	// THEN : returns true
	@Test
	public void twoEmptyArrayListTest() {

		assertTrue(testArrayList1.equals(testArrayList2));
		assertTrue(testArrayList2.equals(testArrayList1));

	}

	// GIVEN : two empty LinkedLists
	// WHEN : calling equals method
	// THEN : returns true
	@Test
	public void twoEmptyLinkedListTest() {

		assertTrue(testLinkedList1.equals(testLinkedList2));
		assertTrue(testLinkedList2.equals(testLinkedList1));

	}

	// GIVEN : two empty both lists
	// WHEN : calling equals method
	// THEN : returns true
	@Test
	public void twoEmptyBothListsTest() {

		assertEquals(testArrayList1, testLinkedList2);
		assertEquals(testLinkedList2, testArrayList1);

	}

	// GIVEN : two same elements Array Lists lists
	// WHEN : calling equals method
	// THEN : returns true
	@Test
	public void twoArrayListsSameElementsTest() {

		testArrayList1.add(validObjectTest2);
		testArrayList1.add(validObjectTest3);
		testArrayList1.add(validObjectTest4);

		testArrayList2.add(validObjectTest2);
		testArrayList2.add(validObjectTest3);
		testArrayList2.add(validObjectTest4);

		assertTrue(testArrayList1.equals(testArrayList2));
		assertTrue(testArrayList2.equals(testArrayList1));

	}

	// GIVEN : two same elements LinkedLists lists
	// WHEN : calling equals method
	// THEN : returns true
	@Test
	public void twoLinkedListsSameElementsTest() {

		testLinkedList2.add(validObjectTest2);
		testLinkedList2.add(validObjectTest3);
		testLinkedList2.add(validObjectTest4);

		testLinkedList1.add(validObjectTest2);
		testLinkedList1.add(validObjectTest3);
		testLinkedList1.add(validObjectTest4);

		assertTrue(testLinkedList1.equals(testLinkedList2));
		assertTrue(testLinkedList2.equals(testLinkedList1));

	}

	// GIVEN : two same elements both lists
	// WHEN : calling equals method
	// THEN : returns true
	@Test
	public void twoBothListsSameElementsTest() {

		testLinkedList2.add(validObjectTest2);
		testLinkedList2.add(validObjectTest3);
		testLinkedList2.add(validObjectTest4);

		testArrayList1.add(validObjectTest2);
		testArrayList1.add(validObjectTest3);
		testArrayList1.add(validObjectTest4);
		
		assertEquals(testArrayList1, testLinkedList2);
		assertEquals(testArrayList2, testLinkedList1);
		

	}

	// GIVEN : two same elements different positions Array Lists lists
	// WHEN : calling equals method
	// THEN : returns false
	@Test
	public void twoArrayListsSameElementsDiffrentPositionsTest() {

		testArrayList1.add(validObjectTest3);
		testArrayList1.add(validObjectTest2);
		testArrayList1.add(validObjectTest4);

		testArrayList2.add(validObjectTest2);
		testArrayList2.add(validObjectTest3);
		testArrayList2.add(validObjectTest4);

		assertFalse(testArrayList1.equals(testArrayList2));
		assertFalse(testArrayList2.equals(testArrayList1));

	}

	// GIVEN : two same elements different positions LinkedLists lists
	// WHEN : calling equals method
	// THEN : returns False
	@Test
	public void twoLinkedListsSameElementsDiffrentPositionsTest() {

		testLinkedList2.add(validObjectTest3);
		testLinkedList2.add(validObjectTest2);
		testLinkedList2.add(validObjectTest4);

		testLinkedList1.add(validObjectTest2);
		testLinkedList1.add(validObjectTest3);
		testLinkedList1.add(validObjectTest4);

		assertFalse(testLinkedList1.equals(testLinkedList2));
		assertFalse(testLinkedList2.equals(testLinkedList1));

	}

	// GIVEN : two same different positions elements both lists
	// WHEN : calling equals method
	// THEN : returns False
	@Test
	public void twoBothListsSameElementsDiffrentPositionsTest() {

		testLinkedList2.add(validObjectTest3);
		testLinkedList2.add(validObjectTest2);
		testLinkedList2.add(validObjectTest4);

		testArrayList1.add(validObjectTest2);
		testArrayList1.add(validObjectTest3);
		testArrayList1.add(validObjectTest4);

		assertFalse(testArrayList1.equals(testLinkedList2));
		assertFalse(testLinkedList2.equals(testArrayList1));

	}

	// GIVEN : two different elements Array Lists lists
	// WHEN : calling equals method
	// THEN : returns false
	@Test
	public void twoArrayListsDiffrentElementsTest() {

		testArrayList1.add(validObjectTest3);
		testArrayList2.add(validObjectTest2);

		/*
		 * assertFalse(testArrayList1.equals(testArrayList2));
		 * assertFalse(testArrayList2.equals(testArrayList1));
		 */
		assertNotEquals(testArrayList1, testArrayList2);
	}

	// GIVEN : two different elements LinkedLists lists
	// WHEN : calling equals method
	// THEN : returns False
	@Test
	public void twoLinkedListsDifferentElementsTest() {

		testLinkedList2.add(validObjectTest3);
		testLinkedList1.add(validObjectTest2);

		assertFalse(testLinkedList1.equals(testLinkedList2));
		assertFalse(testLinkedList2.equals(testLinkedList1));

	}

	// GIVEN : two different elements both lists
	// WHEN : calling equals method
	// THEN : returns False
	@Test
	public void twoBothListsDifferentElementsTest() {

		testLinkedList2.add(validObjectTest3);
		testArrayList1.add(validObjectTest2);

		assertFalse(testArrayList1.equals(testLinkedList2));
		assertFalse(testLinkedList2.equals(testArrayList1));

	}

}
