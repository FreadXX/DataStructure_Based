package com.lsmaker.Node;

public class DoubleNode<E> {
	
	public DoubleNode () {
		this(null, null, null);
	}
	
	public DoubleNode (E element, DoubleNode<E> preNode, DoubleNode<E> nextNode) {
		this.element = element;
		this.previousNode = preNode;
		this.nextNode = nextNode;
	}
	
	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}
	/**
	 * @param element the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}
	/**
	 * @return the previousNode
	 */
	public DoubleNode<E> getPreviousNode() {
		return previousNode;
	}
	/**
	 * @param previousNode the previousNode to set
	 */
	public void setPreviousNode(DoubleNode<E> previousNode) {
		this.previousNode = previousNode;
	}
	/**
	 * @return the nextNode
	 */
	public DoubleNode<E> getNextNode() {
		return nextNode;
	}
	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(DoubleNode<E> nextNode) {
		this.nextNode = nextNode;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof DoubleNode)) {
			return false;
		} else {
			DoubleNode<E> n = (DoubleNode<E>) obj;
			if(n.getElement().equals(element)) {
				return true;
			} else {
				return false;
			}
		}
	}



	private E element;
	private DoubleNode<E> previousNode;
	private DoubleNode<E> nextNode;
}
