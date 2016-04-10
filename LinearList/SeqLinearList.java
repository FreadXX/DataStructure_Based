package com.lsmaker.LinearStructure;

import java.util.ArrayList;

/**
 * A class of SeqLinearList. 
 * @author LS
 *
 * @param <E>
 */
public class SeqLinearList<E> extends LinearList<E> {
	
	public SeqLinearList() {
		new ArrayList<E>(MAXLENGTH).toArray(elements);
		length = 0;
	}
	
	public SeqLinearList(E[] elements, int length) {
		this.elements = elements;
		this.length = length;
	}
	
	
	@Override
	public boolean isEmpty() {
		return length == 0 ? true:false;
	}

	@Override
	public void insert(E element) {
		insert(element, length);
	}

	@Override
	public void insert(E element, int index) {
		if(isFull() == true) {
			overFlow();
		}
		for(int i=length; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		length++;
	} 

	@Override
	public E delete() {
		return delete(length);
	}

	@Override
	public E delete(int index) {
		if(isEmpty() == true) {
			System.out.println("LinearList Empty!");
			return null;
		}
		E element = elements[index];
		for(int i= index; i<length-1;i++) {
			elements[i] = elements[i+1];
		}
		length--;
		return element;
	}

	@Override
	public int find(E element) {
		int index = -1;
		for(int i=0;i<elements.length;i++) {
			if(elements[i].equals(element)) {
				index = i;
			}
		}
		return index;
	}
	
	public boolean isFull() {
		if(length == elements.length) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("null")
	private void overFlow() {
		int currentLength = length + FLOWLENGTH;
		E[] tempelements = null;
		new ArrayList<E>(currentLength).toArray(tempelements);
		for(int i=0;i<length;i++) {
			tempelements[i] = elements[i];
		}
		elements = tempelements;
	}
	
	private static final int MAXLENGTH = 50;
	private static final int FLOWLENGTH = 20;
	
	private E[] elements;
	private int length;
}
