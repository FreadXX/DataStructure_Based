package com.lsmaker.Node;

/**
 * A concrete class of a simple Node.
 * A simple Node contains a element and a point refer to the next SimpleNode
 * this class provides the getter and setter methods for the element and next-node point
 * this class overwrite the Object.equals(Object obj) method to judge whether two nodes are equal or not.
 * @author LS
 *
 * @param <E>	the type of elements in the node
 */
public class SimpleNode<E> {
	
	public SimpleNode() {
		this(null, null);
	}
	
	
	public SimpleNode(E element, SimpleNode<E> nextNode) {
		this.element = element;
		this.nextNode = nextNode;
	}
	
	
	public E getElement() {
		return element;
	}


	public void setElement(E element) {
		this.element = element;
	}


	public SimpleNode<E> getNextNode() {
		return nextNode;
	}


	public void setNextNode(SimpleNode<E> nextNode) {
		this.nextNode = nextNode;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)  return true;
		if(obj == null) return false;
		if(!(obj instanceof SimpleNode)) {
			return false;
		} else {
			SimpleNode<E> n = (SimpleNode<E>) obj;
			if(n.getElement().equals(this.getElement())) {
				return true;
			} else {
				return false;
			}
		}
	}



	private E element;
	private SimpleNode<E> nextNode;
}
