package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;

public class HashCodeTests {

	private List testLinkedList;
	private List testLinkedListDifferent;
	private List testArrayList;
	private List testArrayListSame;
	private List testArrayListDifferent;
	private List listEmpty;
	private List listFewElements;
	private Object validObjectTest1;
	private Object validObjectTest2;
	private Object validObjectTest3;

	@Before
	public void setUp() throws Exception {
		
		listEmpty = new ArrayList();
		listFewElements = new LinkedList();
		testLinkedList = new LinkedList();
		testArrayList = new ArrayList();
		testArrayListSame = new ArrayList();
		testArrayListDifferent = new ArrayList();
		testLinkedListDifferent = new LinkedList();
		
		validObjectTest1 = new String("1");
		validObjectTest2 = new String("2");
		validObjectTest3 = new String("3");
		
		listFewElements.add(validObjectTest1);
		listFewElements.add(validObjectTest2);
		listFewElements.add(validObjectTest3);
		
		testLinkedList.add(validObjectTest1);
		testLinkedList.add(validObjectTest2);
		
		testArrayList.add(validObjectTest1);
		testArrayList.add(validObjectTest2);

		testArrayListSame.add(validObjectTest1);
		testArrayListSame.add(validObjectTest2);
		
		testArrayListDifferent.add(validObjectTest3);
		testArrayListDifferent.add(validObjectTest2);
		
		testLinkedListDifferent.add(validObjectTest1);
		testLinkedListDifferent.add(validObjectTest3);
		
	}

	// GIVEN : hash code on emptyLits
	// WHEN : calling an hashCode
	// THEN : 0 returned
	@Test
	public void emptyListHashCodeTest() {
		assertEquals(1, listEmpty.hashCode());
	}

	// GIVEN : hash code on fullList
	// WHEN : calling an hashCode
	// THEN : hashCode of List returned
	@Test
	public void fullListHashCodeTest() {

		int hashCodeResult = 1;
		int prime = 31;
		
		for (int i = 0; i < listFewElements.size(); i++) {
			hashCodeResult = prime * hashCodeResult + 
					((listFewElements.get(i) == null ) ? 0 : listFewElements.get(i).hashCode());
		}

		assertEquals(hashCodeResult, listFewElements.hashCode());
	}

	// GIVEN : two same lists
	// WHEN : calling an hashCode
	// THEN : same hash codes for both
	@Test
	public void TwoSameHashCodeTest() {
		assertEquals(testArrayList.hashCode(), testArrayListSame.hashCode());
	}

	// GIVEN : two different types of lists with same elements at same positions
	// WHEN : calling an hashCode
	// THEN : same hash codes for both
	@Test
	public void TwoDifferentListsSameElementstHashCodeTest() {
		assertEquals(testLinkedList.hashCode(), testArrayList.hashCode());
	}

	// GIVEN : two different types list with positions of same elements different
	// WHEN : calling an hashCode
	// THEN : same hash codes for both
	@Test
	public void TwoDifferenListsMixedElementstHashCodeTest() {
		assertFalse(testArrayListDifferent.hashCode() 
				== testLinkedListDifferent.hashCode());

	}

}
