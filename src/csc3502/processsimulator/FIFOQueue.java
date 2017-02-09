package csc3502.processsimulator;

public class FIFOQueue implements Queue {

	Node head = new Node(null);
	Node pointer = head;

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
		// TODO Auto-generated method stub
		pointer.next = new Node(p);
		pointer = pointer.next;

	}

	@Override
	public Process poll() {
		// TODO Auto-generated method stub
		Node q = head.next;
		head = head.next;
		return q.process;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next == null;
	}

	@Override
	public String getSignature() {
		// TODO Auto-generated method stub
		return "Gavin Liu";
	}
}
