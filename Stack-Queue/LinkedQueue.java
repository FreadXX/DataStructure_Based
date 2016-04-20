package com.lsmaker.Stack_Queue;

import com.lsmaker.LinearList.LinkedLinearList;

public class LinkedQueue<E> extends Queue<E> {
	
	public LinkedQueue() {
		elements = new LinkedLinearList<E>();
		rear = 0;
		length = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public void enQueue(E element) {
		elements.insert(element);
		rear++;
		length++;
	}

	@Override
	public E deQueue() {
		rear--;
		length--;
		return elements.delete(0);
	}

	@Override
	public E getFront() {
		return elements.find(0);
	}
	
	private int rear;
	private int length;
	
}
