package com.lsmaker.LinearList;

import com.lsmaker.Node.SimpleNode;

public class CirclableLinkedLinearList<E> extends LinkedLinearList<E> implements Circlable {

	public CirclableLinkedLinearList() {
		super();
	}

	@Override
	public void circle() {
		if (getRoot() != null) {
			SimpleNode<E> n = getRoot();
			for (int i = 0; i < getLength() - 1; i++) {
				n = n.getNextNode();
			}
			n.setNextNode(getRoot());
		}

	}

	@Override
	public void insert(E element) {
		if (getLength() == 0) {
			insert(element, getLength());
		} else {
			insert(element, getLength() - 1);
		}
	}

	@Override
	public E delete() {
		return delete(getLength() - 1);
	}

	@Override
	public void insert(E element, int index) {
		super.insert(element, index);
		circle();
	}

	@Override
	public E delete(int index) {
		E result = super.delete(index);
		circle();
		return result;
	}

	@Override
	public int find(E element) {
		if (getLength() == 0)
			return -1;
		SimpleNode<E> n = getRoot();
		int index = 0;
		do {
			if (n.getElement().equals(element)) {
				return index;
			} else {
				n = n.getNextNode();
				index++;
			}
		} while (n != getRoot());
		return -1;
	}

	@Override
	public String traverse() {
		return super.traverse();
	}

}
