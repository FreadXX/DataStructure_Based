package com.lsmaker.LinearList;

import com.lsmaker.Node.DoubleNode;

public class DoubleLinkedLinearList<E> extends LinearList<E>{
	
	public DoubleLinkedLinearList() {
		root = null;
		length = 0;
	}
	
	/**
	 * @return the root
	 */
	public DoubleNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(DoubleNode<E> root) {
		this.root = root;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public boolean isEmpty() {
		
		return length==0;
	}

	@Override
	public void insert(E element) {
		insert(element, length-1>0 ? length-1 : 0);
	}

	@Override
	public void insert(E element, int index) {
		if(index < 0 || index > length) {
			System.out.println("Insert Index Error!");
			return ;
		}
		DoubleNode<E> n = root;
		DoubleNode<E> newNode = new DoubleNode<E>(element, null, null);
		if(length == 0) {			// if the root is null, set the new node as the root
			root = newNode;
		} else {
			for(int i=0;i<index;i++) {
				n = n.getNextNode();
			}
			DoubleNode<E> p = n.getNextNode();	
			if(p != null) {
				newNode.setNextNode(p);
				p.setPreviousNode(newNode);
			}
			n.setNextNode(newNode);
			newNode.setPreviousNode(n);
		}
		length++;
	}

	@Override
	public E delete() {
		return delete(length-1);
	}

	@Override
	public E delete(int index) {
		DoubleNode<E> result;
		if(index < 0 || index >= length) {
			System.out.println("Delete Index Error!");
			return null;
		}
		if(isEmpty() == true) {
			System.out.println("List Empty! Delete Failed!");
			return null;
		}
		if(length == 1) {
			E temp = root.getElement();
			result = null;
			length--;
			return temp;
		} else {
			DoubleNode<E> n = root;
			for(int i=0;i<index-1;i++) {
				n = n.getNextNode();
			}
			result = n.getNextNode();
			DoubleNode<E> p = result.getNextNode();
			if(p!=null) {
				p.setPreviousNode(n);
			}
			n.setNextNode(p);
		}
		length --;
		return result.getElement();
	}

	@Override
	public int search(E element) {
		DoubleNode<E> n = root;
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
		DoubleNode<E> n = getRoot();
		for(int i=0; i < index; i++) {
			n = n.getNextNode();
		}
		return n.getElement();
	}
	
	@Override
	public String traverse() {
		if (length == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		DoubleNode<E> n = root;
		for (int i = 0; i < length - 1; i++) {
			result.append(n.getElement().toString() + ",");
			n = n.getNextNode();
		}
		result.append(n.getElement().toString());
		return result.toString();
	}
	
	
	private DoubleNode<E> root;
	private int length;
	
}
