package toolClasses;

public class ArrayQueue<E> implements Queue<E> {
	private final static int INITCAP = 4; 
	private E[] elements; 
	private int first, size; 
	public ArrayQueue() { 
		elements = (E[]) new Object[INITCAP]; 
		first = 0; 
		size = 0; 
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) 
			return null; 
		return elements[first]; 
	}

	public E dequeue() {
		if (isEmpty()) 
			return null;
		E etr = elements[first]; 

		int carry = 1;
		while (carry < size) {
			elements[carry-1]=elements[carry];
			carry++;
		}
		elements[carry-1]=null;
		size--;
		// Check if number of available positions in the array exceed 3/4
		// of its total length. If so, and if the current capacity is not
		// less than 2*INITCAP, shrink the internal array to 1/2 of its
		// current length (the capacity of the queue). 
		if (elements.length >= 2*INITCAP && size < elements.length/4)
			changeCapacity(elements.length/2); 
		return etr; 
	}

	public void enqueue(E e) { //
		if (size == elements.length)   // check capacity, double it if needed
			changeCapacity(2*size); 
		elements[size]=e;
		size++;
	}

	private void changeCapacity(int newCapacity) { 
		// PRE: newCapacity >= size
		int carry = 0;
		E[] temp = (E[]) new Object[newCapacity];
		while (carry<size) {
			temp[carry]=elements[carry];
			carry++;
		}
		elements = temp;
	}
	
	public void sort(Queue<E> q) {
		if (q.size()>1) {
			Queue<E> q1, q2;
			// Initialize q1 and q2 to empty instances of ArrayQueue as implemented in previous lab.
			q1 = new ArrayQueue<>();
			q2 = new ArrayQueue<>();
			// split the elements of q in two halves (or close to), first half into q1 and second half into q2
			int n = q.size();
			for (int i=0; i<n/2; i++)
				q1.enqueue(q.dequeue());
			while (!q.isEmpty())
				q2.enqueue(q.dequeue());

			sort(q1); // recursively sort q1
			sort(q2); // recursively sort q2

			// What is left to do now is the merging operation​. Given that q1 and q2 are each sorted,
			// efficiently combine is elements back into q so that they are placed in order from first to last.
			// This process efficiently exploits the property that both, q1 and q2, are sorted.
			while (!q1.isEmpty() && !q2.isEmpty())
				if (((Comparable<E>) q1.first()).compareTo(q2.first()) <= 0)
					q.enqueue(q1.dequeue());
				else
					q.enqueue(q2.dequeue());
			// At this moment, one of the two queues, either q1 or q2, is empty.
			Queue<E> r = (!q1.isEmpty() ? q1 : q2); // find which, q1 or q2, is not empty yet
			while (!r.isEmpty())
				q.enqueue(r.dequeue());
		}
	}
}