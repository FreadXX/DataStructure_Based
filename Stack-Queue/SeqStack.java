package com.lsmaker.Stack_Queue;

import com.lsmaker.LinearList.SeqLinearList;

public class SeqStack<E> extends Stack<E> {
	
	public SeqStack() {
		elements = new SeqLinearList<E>();
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
	
	public String traverse() {
		return elements.traverse();
	}
	
	private int length;
}
