package com.lsmaker.LinearList;

import com.lsmaker.Node.SimpleNode;

public class LinkedLinearList<E> extends LinearList<E> {

	public LinkedLinearList() {
		root = null;
		setLength(0);
	}

	public SimpleNode<E> getRoot() {
		return root;
	}

	public void setRoot(SimpleNode<E> root) {
		this.root = root;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public boolean isEmpty() {
		return getLength() == 0 && getRoot().getElement() == null ? true : false;
	}

	@Override
	public void insert(E element) {
		insert(element, getLength() - 1 >= 0 ? getLength() - 1 : 0);

	}
	
	@Override	
	public void insert(E element, int index) {
		if (index < 0 || index > getLength()) {
			System.out.println("Insert Index Error!");
			return;
		}
		SimpleNode<E> n = getRoot();
		SimpleNode<E> newNode = new SimpleNode<E>(element, null);
		if (n == null) { // if root == null, we directly set the new node as
							// root
			setRoot(newNode);
		} else {
			for (int i = 0; i < index; i++) {
				n = n.getNextNode();
			}
			newNode.setNextNode(n.getNextNode());
			n.setNextNode(newNode);
		}
		length++;
	}

	@Override
	public E delete() {
		return delete(getLength() - 1);
	}

	@Override 
	public E delete(int index) {
		if (index < 0 || index >= getLength()) {
			System.out.println("Delete Index Error!");
			return null;
		}
		if (index == 0 && getLength() == 1) {
			E result = getRoot().getElement();
			getRoot().setElement(null);
			length--;
			return result;
		}
		SimpleNode<E> n = getRoot();
		SimpleNode<E> p = n;
		if (index == 0) {
			E result = root.getElement();
			setRoot(root.getNextNode());
			length--;
			return result;
		} else {
			for (int i = 0; i < index; i++) {
				p = n;
				n = n.getNextNode();
			}
			p.setNextNode(n.getNextNode());
			length--;
			return n.getElement();
		}
	}

	@Override
	public int search(E element) {
		SimpleNode<E> n = getRoot();
		int index = 0;
		while (n != null) {
			if (n.getElement().equals(element)) {
				return index;
			} else {
				n = n.getNextNode();
				index++;
			}
		}
		return -1;
	}
	
	@Override
	public E find(int index) {
		if(index < 0 || index >=getLength()) {
			System.out.println("Find Index Error!");
			return null;
		}
		SimpleNode<E> n = getRoot();
		for(int i=0; i < index; i++) {
			n = n.getNextNode();
		}
		return n.getElement();
	}
	
	@Override
	public String traverse() {
		if (getLength() == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		SimpleNode<E> n = getRoot();
		for (int i = 0; i < length - 1; i++) {
			result.append(n.getElement().toString() + ",");
			n = n.getNextNode();
		}
		result.append(n.getElement().toString());
		return result.toString();
	}

	private SimpleNode<E> root;
	private int length;
	
}
