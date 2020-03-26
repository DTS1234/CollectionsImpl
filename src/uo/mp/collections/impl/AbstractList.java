package uo.mp.collections.impl;

import uo.mp.check.ArgumentsCheck;
import uo.mp.collections.List;

public abstract class AbstractList {

	protected int numberOfElements = 0;

	public AbstractList() {
		super();
	}

	public int size() {
		return numberOfElements;
	}

	public boolean isEmpty() {
		if (this.size() == 0)
			return true;
		return false;
	}

	public boolean contains(Object o) {
	
		if (o == null)
			return false;
	
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(o))
				return true;
		}
	
		return false;
	}
	
	public Object remove(int index) {

		ArgumentsCheck.isTrue(index < 0 || index >= size());

		Object removedValue = this.get(index);
		remove(get(index));

		return removedValue;
	}
	
	public void clear() {

		int index = size() - 1;

		while (size() != 0) {
			remove(index);
			index--;
		}

	}
	
	public int indexOf(Object o) {

		if (o != null) {
			for (int i = 0; i < size(); i++) {
				if (o.equals(get(i))) {
					return i;
				}
			}
		}

		return -1;

	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(!(this instanceof List))
			return false;
		if(!(this.size() == ((List)obj).size()))
			return false;
		for(int i = 0; i<size(); i++) {
			if(!this.get(i).equals(((List)obj).get(i))){
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
	
		if (isEmpty()) {
			return 1;
		}
	
		final int prime = 31;
		int result = 1;
	
		for (int i = 0; i < size(); i++) {
			result = prime * result + (get(i) == null ? 0 : get(i).hashCode());
		}
	
		return result;
	}
	
	@Override
	public String toString() {
	
		String result = "";
	
		if (isEmpty()) {
			result += "[]";
		} else {
	
			result = "[";
	
			for (int i = 0; i < size()-1; i++) {
				result += get(i) + ", ";
			}
	
			result += get(size() - 1);
			result += "]";
		}
	
		return result;
	}
	
	abstract Object get(int index);
	abstract boolean remove(Object element);
	
}