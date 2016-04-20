package com.lsmaker.LinearList;

import com.lsmaker.Node.DoubleNode;

public class CirclableDoubleLinkedLinearList<E> extends DoubleLinkedLinearList<E> implements Circlable {
	
	public CirclableDoubleLinkedLinearList() {
		super();
	}
	
	@Override
	public void circle() {
		// TODO Auto-generated method stub
		DoubleNode<E> n = super.getRoot();
		if (n != null) {
			for(int i=0;i<getLength()-1;i++) {
				n = n.getNextNode();
			}
		}
		n.setNextNode(getRoot());
		getRoot().setPreviousNode(n);
	}
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	@Override
	public void insert(E element) {
		insert(element, getLength()-1>0 ? getLength()-1 : 0);
	}
	
	@Override
	public void insert(E element, int index) {
		super.insert(element, index);
		circle();
	}
	
	@Override
	public E delete() {
		return delete(getLength()-1);
	}
	
	@Override
	public E delete(int index) {
		E result = super.delete(index);
		circle();
		return result;
	}
	
	@Override
	public int search(E element) {
		return super.search(element);
	}
	
	@Override
	public String traverse() {
		return super.traverse();
	}
}
