package com.lsmaker.Stack_Queue;

import com.lsmaker.LinearList.SeqLinearList;

public class SeqDeQueue<E> extends DeQueue<E> {
	
	public SeqDeQueue() {
		elements = new SeqLinearList<E>();
		length = 0;
		rear = 0;
		operation_tag = 1;
	}
	
	@Override
	public void enQueueLast(E element) {
		elements.insert(element, 0);
		rear++;
		length++;
		operation_tag = 2;
	}

	@Override
	public E deQueueLast() {
		E element = elements.delete(rear-1);
		if(element != null) {
			length--;
			rear--;
			operation_tag = 1;
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return length == 0 && operation_tag == 1;
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
		if(element != null) {
			rear--;
			length--;
			operation_tag = 1;
		}
		return element;
	}

	@Override
	public E getFront() {
		return elements.find(0);
	}
	
	
	private int length;
	private int rear;
	private int operation_tag;
}
