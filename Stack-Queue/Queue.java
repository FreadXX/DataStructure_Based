package com.lsmaker.Stack_Queue;

import com.lsmaker.LinearList.LinearList;

public abstract class Queue<E> {
	
	LinearList<E> elements;
	
	public abstract boolean isEmpty();
	
	public abstract void enQueue(E element);
	
	public abstract E deQueue();
	
	public abstract E getFront();
}
