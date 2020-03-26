package uo.mp.collections.impl;

import uo.mp.check.ArgumentsCheck;
import uo.mp.collections.List;

public class ArrayList extends AbstractList implements List {

	private Object[] elements;
	private static final int INITIAL_CAPACITY = 20;

	public ArrayList() {
		this.elements = new Object[INITIAL_CAPACITY];
	}

	@Override
	public boolean add(Object element) {

		ArgumentsCheck.isNull(element);

		if (isArrayToSmall()) {
			this.increaseCapacity();
		}

		this.addElementToTheEnd(element);
		this.numberOfElements++;

		return true;

	}

	@Override
	public boolean remove(Object o) {

		if(!checkInvariants(o)) {
			return false;
		}

		int index = this.indexOf(o);

		for (int i = index; i < size() - 1; i++)
			elements[i] = elements[i + 1];
		
		numberOfElements--;
		elements[size()] = null;

		return true;

	}
	
	
	@Override
	public Object get(int index) {

		ArgumentsCheck.isTrue(index < 0 || index >= size());

		return elements[index];
	}

	@Override
	public Object set(int index, Object element) {

		ArgumentsCheck.isTrue(index < 0 || index > size());
		ArgumentsCheck.isNull(element);

		
		Object replacedValue = get(index);
		elements[index] = element;

		return replacedValue;
	}

	@Override
	public void add(int index, Object element) {

		ArgumentsCheck.isTrue(index < 0 || index > size());
		ArgumentsCheck.isNull(element);

		if (isArrayToSmall()) {
			this.increaseCapacity();
		}

		for (int i = size(); i > index; i--) {
			this.elements[i] = this.elements[i - 1];
		}

		this.elements[index] = element;
		this.numberOfElements++;

	}
	
	private boolean isArrayToSmall() {
		if (this.size() >= INITIAL_CAPACITY)
			return true;
		return false;
	}

	private void increaseCapacity() {
		Object[] elemenstWithNewCapacity = new Object[2 * elements.length];
		System.arraycopy(elements, 0, elemenstWithNewCapacity, 0, elements.length);
		elements = elemenstWithNewCapacity;
	}

	private void addElementToTheEnd(Object element) {
		this.elements[this.size()] = element;
	}
	
	private boolean checkInvariants(Object o) {
		if(o == null || !this.contains(o)) {
			return false;
		}
		return true;
	}

	
}
