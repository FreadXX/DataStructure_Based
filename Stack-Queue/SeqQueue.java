package com.lsmaker.Stack_Queue;

import com.lsmaker.LinearList.SeqLinearList;

public class SeqQueue<E> extends Queue<E> {
	
	public SeqQueue() {
		elements = new SeqLinearList<E>();
		operation_tag = 1;
		rear = 0;
		length = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return rear == length && operation_tag == 1;
	}

	@Override
	public void enQueue(E element) {
		
		elements.insert(element, rear);
		rear++;
		length++;
		operation_tag = 2;
	}

	@Override
	public E deQueue() {
		E element = elements.delete(0);
		rear--;
		length--;
		operation_tag = 1;
		return element;
	}

	@Override
	public E getFront() {
		return elements.find(0);
	}
	
	private int operation_tag;
	private int rear;
	private int length;
}
