package com.lsmaker.Stack_Queue;

import com.lsmaker.LinearList.LinearList;

/**
 * A abstract class of stack.
 * Stack is the first-in-last-out linear data structure.
 * this class gives a basic description of stack.
 * @author Administrator
 *
 * @param <E> the type of element in the stack
 */
public abstract class Stack<E> {
	
	protected LinearList<E> elements;
	
	public abstract boolean isEmpty();
	
	public abstract void push(E ele);
	
	public abstract void pop();
	
	public abstract E getTop();
}
