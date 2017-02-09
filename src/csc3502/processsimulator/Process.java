package csc3502.processsimulator;

public class Process {
	private int id;
	private double arrivalTime;
	private int priority;

	// setting parameters
	private double maxBurst = 60;
	private double minBurst = 10;

	public Process(int id, double arrivalTime, int priority, double maxBurst, double minBurst) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.priority = priority;
		this.maxBurst = maxBurst;
		this.minBurst = minBurst;
	}

	public int getId() {
		return id;
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public int getPriority() {
		return priority;
	}

	public boolean hasMoreBurst() {
		return Math.random() > 0.3;
	}

	public double getNextBurstTime() {
		return (int) (Math.random() * (maxBurst - minBurst) + minBurst);
	}

}
