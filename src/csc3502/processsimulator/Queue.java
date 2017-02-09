package csc3502.processsimulator;

public interface Queue {

	void offer(Process p);

	Process poll();
	
	boolean isEmpty();
	
	String getSignature();
}
