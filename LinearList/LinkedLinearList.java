package com.lsmaker.LinearList;

import com.lsmaker.Node.SimpleNode;

public class LinkedLinearList<E> extends LinearList<E> {
	
	public LinkedLinearList() {
		root = new SimpleNode<E>();
		length = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return length == 0 && root.getElement() == null? true:false;
	}

	@Override
	public void insert(E element) {
		if(length == 0) {
			insert(element, length);
		} else {
			insert(element, length-1);
		}
		
	}

	@Override
	public void insert(E element, int index) {
		if(index < 0 || index > length) {
			System.out.println("Insert Index Error!");
			return ;
		}
		SimpleNode<E> n = root;
		SimpleNode<E> newNode = new SimpleNode<E>(element, null);
		if(index == 0) {
			if(root.getElement() == null) {
				root.setElement(element);
			} else {
				newNode.setNextNode(n);
				root = newNode;
			}
		} else {
			SimpleNode<E> p = n;
			for(int i = 0;i < index; i++) {
				p = n;
				n = n.getNextNode();
			}
			newNode.setNextNode(p.getNextNode());
			p.setNextNode(newNode);
		}
		
		length++;
	}

	@Override
	public E delete() {
		return delete(length-1);
	}

	@Override
	public E delete(int index) {
		if(index < 0 || index >= length) {
			System.out.println("Delete Index Error!");
			return null;
		}
		SimpleNode<E> n = root;
		if(index == 0) {
			root = n.getNextNode();
			length --;
			return n.getElement();
		} else {
			for(int i=0;i<index-1;i++) {
				n = n.getNextNode();
			}
			SimpleNode<E> deleteNode = n.getNextNode();
			n.setNextNode(n.getNextNode().getNextNode());
			length --;
			return deleteNode.getElement();
		}
		
	}

	@Override
	public int find(E element) {
		SimpleNode<E> n = root;
		int index = 0;
		while(n!=null) {
			if(n.getElement().equals(element)) {
				return index;
			} else {
				n = n.getNextNode();
				index++;
			}
		}
		return -1;
	}

	@Override
	public String traverse() {
		StringBuilder result = new StringBuilder();
		SimpleNode<E> n = root;
		while(n.getNextNode()!=null) {
			result.append(n.getElement().toString() + ",");
			n = n.getNextNode();
		}
		result.append(n.getElement().toString());
		return result.toString();
	}
	
	
	private SimpleNode<E> root;
	private int length;
}
