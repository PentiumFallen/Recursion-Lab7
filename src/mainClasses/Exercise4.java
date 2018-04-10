package mainClasses;

import java.util.ArrayList;
import toolClasses.Pair;
import toolClasses.SLL;

public class Exercise4 {
	public static void main(String[] args) {
		SLL<Integer> list = new SLL<>();
		for (int i = 0; i < 10; i++)
			list.addNode(9-i);

		System.out.println("The list contains "+list.toString());
		ArrayList<Integer> less = list.lessThan(4);
		System.out.println("The elements < 4 are "+less.toString());
		ArrayList<Pair<Integer>> cip = list.consecutiveIncreasingPairs();
		System.out.print("The consecutive pairs are [");
		for (int i = 0; i < cip.size()-1; i++) {
			System.out.print("("+cip.get(i).first()+","+cip.get(i).second()+"), ");
		}
		System.out.print("("+cip.get(cip.size()-1).first()+","+cip.get(cip.size()-1).second()+")]");
	}
}
