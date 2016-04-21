package com.lsmaker.Stack_Queue;


public abstract class DeQueue<E> extends Queue<E> {

	public void enQueueFirst(E element) {
		enQueue(element);
	}
	
	public E deQueueFirst() {
		return deQueue();
	}
	
	public abstract void enQueueLast(E element);
	
	public abstract E deQueueLast();
}
