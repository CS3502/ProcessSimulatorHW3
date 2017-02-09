package csc3502.processsimulator;

/*
 * Homework 3:
 * @Author you name here..
 * Goal: finish the code in each functions to provide priority queue.
 * Note that in this class, PriorityQueue class in java library is not allowed to be used here.
 * You could implement and maintain a sorted linked list using the class Node below.
 * You are not allowed to change other classes except this one.
 */

public class PriorityQueue implements Queue {

	Node head = new Node(null);

	class Node {
		Process process;
		Node next;

		Node(Process p) {
			this.process = p;
			this.next = null;
		}
	}

	@Override
	public void offer(Process p) {
		// implement this method
	}

	@Override
	public Process poll() {
		// implement this method

		return null;
	}

	@Override
	public boolean isEmpty() {
		// implement this method

		return true;
	}

	@Override
	public String getSignature() {
		// change this string to your name
		return "Gavin Liu";
	}
}
