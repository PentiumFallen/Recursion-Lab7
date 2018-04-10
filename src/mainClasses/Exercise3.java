package mainClasses;

import toolClasses.SLL;

public class Exercise3 {

	public static void main(String[] args) {
		SLL<Integer> list = new SLL<>();
		for (int i = 0; i < 10; i++)
			list.addNode(i);
		
		System.out.println("The list contains "+list.toString());
		list.reverse();
		System.out.println("The list is now "+list.toString());
	}
}
