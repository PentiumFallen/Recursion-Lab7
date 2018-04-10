package toolClasses;

public class Pair<E> {
	E first;
	E second;
	
	public Pair(E first, E second) {
		this.first = first;
		this.second = second;
	}

	public E first() {
		return first;
	}

	public E second() {
		return second;
	}
}
