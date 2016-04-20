package com.lsmaker.LinearList;

/**
 * The abstract class of LinearList
 *  linearlist is the most widely used data structure in programming.
 *  this class gives a basic description of a list.
 * @author Administrator
 *
 */
public abstract class LinearList<E> {
	
	
	/**
	 * this method reflect the elements in a linearlist.
	 * if there is no element in linearlist, method returns true. else returns false;
	 * @return true for empty linearlist, false for non-empty linearlist.
	 */
	public abstract boolean isEmpty();
	
	/**
	 * this method insert the specified element into the linearlist.
	 * if the list is ordered, this element will insert into the tail of the linearlist.
	 * @param element the element to insert
	 */
	public abstract void insert(E element);
	
	/**
	 * this method insert the specified element into the linearlist.
	 * if the list is ordered, this element will insert into the index i of the linearlist.
	 * @param element	the element to insert
	 * @param index		the index to insert
	 */
	public abstract void insert(E element, int index);
	
	/**
	 * this method delete the element from the linearlist and return the deleted element.
	 * if the list is ordered, this element will delete the last element of the list.
	 * @return the deleted element
	 */
	public abstract E delete();
	
	/**
	 * this method delete the specified element from the linearlist and return the deleted element.
	 * if the list is ordered, this element will delete the element in the index i of the list.
	 * @return the deleted element
	 */
	public abstract E delete(int index);
	
	/**
	 * this method search the specified element from the linearlist and return the index of the element.
	 * if there are more than one elements equal to the specified one in linearlist, return the index of the last element.
	 * if there are no elements matching in linearlist, return -1.
	 * @param element the specified element to search
	 * @return	the index of the element, -1 for none.
	 */
	public abstract int search(E element);
	
	public abstract E find(int index);
	
	/**
	 * this method traverse all elements in the linearlist.
	 * use the toString() method to Convert the Element to String, 
	 * and concat the String with mark ','.
	 * @return the traversal String connected by ','
	 */
	public abstract String traverse();
}
