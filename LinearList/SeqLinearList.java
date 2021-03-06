package com.lsmaker.LinearList;

import java.util.ArrayList;
import java.util.List;

/**
 * A class of SeqLinearList. 
 * @author LS
 *
 * @param <E>
 */
public class SeqLinearList<E> extends LinearList<E> {
	
	public SeqLinearList() {
		this(null, 0);
	}
	
	public SeqLinearList(E[] elements, int length) {
		this.elements = new ArrayList<E>(MAXLENGTH);
		if(elements != null) {
			for(int i=0;i<elements.length;i++) {
				insert(elements[i]);
			}
		}
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
		if(length == MAXLENGTH) {
			overFlow();
		}
		if(index < 0 || index > length) {
			System.out.println("Illegal Parameter : index");
			return ;
		}
		elements.add(index,element);
		length++;
	} 

	@Override
	public E delete() {
		return delete(length-1);
	}

	@Override
	public E delete(int index) {
		if(isEmpty() == true) {
			System.out.println("LinearList Empty!");
			return null;
		}
		if(index < 0 || index >= length) {
			System.out.println("Illegal Parameter : index");
			return null;
		}
		E element = elements.get(index);
		for(int i= index; i<length-1;i++) {
			elements.set(i, elements.get(i+1));
		}
		elements.set(--length, null);
		return element;
	}

	@Override
	public int search(E element) {
		int index = -1;
		for(int i=0;i<length;i++) {
			if(elements.get(i).equals(element)) {
				index = i;
			}
		}
		return index;
	}
	
	@Override
	public E find(int index) {
		return elements.get(index);
	}
	
	public boolean isFull() {
		if(length == MAXLENGTH) {
			return true;
		}
		return false;
	}
	
	private void overFlow() {
		int currentLength = length + FLOWLENGTH;
		List<E> tempelements = new ArrayList<E>(currentLength);
		for(int i=0;i<length;i++) {
			tempelements.set(i, elements.get(i));
		}
		elements = tempelements;
		MAXLENGTH += FLOWLENGTH;
	}
	
	
	@Override
	public String traverse() {
		StringBuilder result = new StringBuilder();
		if(length > 0) {
			for(int i=0;i<length-1;i++) {
				result.append(elements.get(i).toString() + ",");
			}
			result.append(elements.get(length-1));
		}
		return result.toString();
	}
	
	protected int MAXLENGTH = 50;
	private static final int FLOWLENGTH = 20;
	
	private List<E> elements;
	private int length;
	
	
}
