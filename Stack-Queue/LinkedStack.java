package com.lsmaker.Stack_Queue;

import com.lsmaker.LinearList.LinkedLinearList;

public class LinkedStack<E> extends Stack<E> {
	
	public LinkedStack() {
		elements = new LinkedLinearList<E>();
		length = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public void push(E ele) {
		elements.insert(ele);
		length++;

	}

	@Override
	public void pop() {
		elements.delete();
		length--;
	}

	@Override
	public E getTop() {
		return elements.find(length-1);
	}
	
	private int length;
	
}
