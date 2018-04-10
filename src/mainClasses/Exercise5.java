package mainClasses;

import java.util.ArrayList;
import java.util.Random;
import toolClasses.ArrayQueue;

public class Exercise5 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for (int i=0; i<10;i++)
			list.add(rand.nextInt(20));
		
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		for (Integer i : list) {
			queue.enqueue(i);
		}
		
		System.out.println("The original list is "+list.toString());
		queue.sort(queue);
		System.out.print("The sorted queue is: [");
		for (int i = 0; i < list.size()-1; i++) {
			System.out.print(queue.dequeue()+", ");
		}
		System.out.print(queue.dequeue()+"]");
	}
}
