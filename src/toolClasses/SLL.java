package toolClasses;

import java.util.ArrayList;

public class SLL<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node(E element) { this(element, null); }
		public Node() { this(null, null); }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }
	}

	private Node<E> first = null;
	private int size = 0;

	public void addFirst(E e) {
		first = new Node<>(e, first);
		size++;
	}

	public void addNode(E e) {
		if (first==null)
			addFirst(e);
		else {
			Node<E> current = first;
			while (current.getNext()!=null)
				current=current.getNext();
			current.setNext(new Node<E>(e));
		}
		size++;
	}

	// returns string formed by elements in this list, separated by spaces
	public String toString() {
		String s = "{";
		Node<E> current = first;
		while (current != null) {
			s += "" + current.getElement();
			if (current.getNext()!=null) {
				s += ", ";
				current = current.getNext();
			}
			else {
				s += "}";
				current = current.getNext();
			}
		}
		return s;
	}

	public void reverse() {
		if (size > 1)
			first = (Node<E>) recReverse(first).first();
	} 

	private Pair<Node> recReverse(Node<E> first) {
		Node<E> originalFirst = first;
		Pair<Node> reverse = new Pair<Node>(recReverse(null, first), originalFirst);
		return reverse;
	}

	private Node<E> recReverse(Node<E> b, Node<E> c) {
		if (c==null) return b;
		Node<E> a=c.getNext();
		c.setNext(b);
		return recReverse(c, a);
	}

	public ArrayList<E> lessThan(E e) {
		ArrayList<E> result = new ArrayList<>(); // an empty ArrayList object
		if (size > 0)
			recLessThan(first, e, result); // passing only reference to result
		return result;
	}

	private void recLessThan(Node<E> fr, E e, ArrayList<E> result) {
		if (fr != null) {
			if (((Comparable<E>) fr.getElement()).compareTo(e) < 0)
				result.add(fr.getElement());
			recLessThan(fr.getNext(), e, result); // passing reference to result
		}
	}

	public ArrayList<Pair<E>> consecutiveIncreasingPairs() {
		ArrayList<Pair<E>> result = new ArrayList<>(); // and empty ArrayList object
		if (size > 0)
			recCIP(first, result);
		return result;
	}

	private void recCIP(Node<E> node, ArrayList<Pair<E>> result) {
		//base case or last case
		if (node.getNext()==null || node.getNext().getNext()==null) {
			if (node.getNext()==null) {	}
			else {
				if (((Comparable<E>) node.getElement()).
						compareTo(node.getNext().getElement())<0)
					result.add(new Pair<E>(node.getElement(), 
							node.getNext().getElement()));
				else
					result.add(new Pair<E>(node.getNext().getElement(), 
							node.getElement()));
			}
			return;
		}
		
		//recursive cases
		if (((Comparable<E>) node.getElement()).
				compareTo(node.getNext().getElement())<0)
			result.add(new Pair<E>(node.getElement(), 
					node.getNext().getElement()));
		else
			result.add(new Pair<E>(node.getNext().getElement(), 
					node.getElement()));

		//recursion call
		recCIP(node.getNext().getNext(), result);
	}
}