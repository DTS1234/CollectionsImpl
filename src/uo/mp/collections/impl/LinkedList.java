package uo.mp.collections.impl;

import uo.mp.check.ArgumentsCheck;
import uo.mp.collections.List;
import uo.mp.collections.impl.node.Node;

public class LinkedList extends AbstractList implements List {

	private Node head;
	@Override
	public boolean add(Object element) {

		ArgumentsCheck.isNull(element);

		if (isEmpty()) {
			addAtFirst(element);
			return true;
		} else {
			addToTheEnd(element);
			this.numberOfElements++;
			return true;
		}
	}

	@Override
	public boolean remove(Object o) {
		
		if(!checkInvariants(o)) {
			return false;
		}
		
		int index = this.indexOf(o);
		
		if (index == 0) {
			this.head = this.head.getNext();
		} else {
			Node previous = getNode(index - 1);
			previous.setNext(previous.getNext().getNext());
		}
		
		numberOfElements--;
		return true;
	}
	
	private boolean checkInvariants(Object o) {
		if(o == null || this.isEmpty()) {
			return false;
		}
		
		int index = this.indexOf(o);
		
		return checkIndex(index);		
	}
	
	private boolean checkIndex(int index) {
		if(index<0 || index >= size()) {
			return false;
		}
		return true;
	}
	
	@Override
	public Object get(int index) {
		
		ArgumentsCheck.isTrue(index < 0);
		ArgumentsCheck.isTrue(index >= size());
				
		return getNode(index).getValue();
	}

	@Override
	public Object set(int index, Object element) {

		ArgumentsCheck.isTrue(index < 0 || index > size());
		ArgumentsCheck.isNull(element);
		Object replacedValue = get(index);
		
		if(index == 0) {
			head.setValue(element);
			return replacedValue;
		}
		
		if(index == size()-1) {
			
			remove(size()-1);
			add(element);
			
			return replacedValue;			 
			
		}
		
		Node iterator = head;
		while (iterator.getNext() != null) {
			
			if (iterator.getValue() == replacedValue) {
				iterator.setValue(element);
				return replacedValue;
			}else {
				iterator = iterator.getNext();
			}
		}
		return replacedValue;
	}
		
	
	@Override
	public void add(int index, Object element) {

		ArgumentsCheck.isTrue(index < 0 || index > size());
		ArgumentsCheck.isNull(element);

		if (index == 0) {
			addAtFirst(element);
		} else if (index == size()) {

			add(element);

		} else {
			Node previous = getNode(index - 1);
			previous.setNext(new Node(element, previous.getNext()));
			this.numberOfElements++;
		}

	}

	@Override
	public Object remove(int index) {

		ArgumentsCheck.isTrue(index < 0 || index >= size());

		Object removedValue = this.get(index);
		remove(get(index));

		return removedValue;
	}

	private void addToTheEnd(Object element) {
		Node last = getNode(size() - 1);
		last.setNext(new Node(element, null));
	}

	private void addAtFirst(Object value) {
		this.head = new Node(value, this.head);
		this.numberOfElements++;
	}

	private Node getNode(int index) {

		int position = 0;
		Node node = this.head;

		while (position < index) {
			node = node.getNext();
			position++;
		}

		return node;

	}
	

	

}
