package csc3502.processsimulator;

import java.util.List;

public class Scheduler {

	static double idleTime = 0;
	static Queue queue = new FIFOQueue();

	public static void executeProcesses() {
		double currentTime = 0;
		System.out.println("Simulation starts with default parameters.");
		while (!queue.isEmpty()) {
			Process process = queue.poll();
			if (process.getArrivalTime() > currentTime) {
				idleTime = process.getArrivalTime() - currentTime;
				currentTime = process.getArrivalTime();
			}
			System.out.printf("process %d started at time %f.\n", process.getId(), currentTime);
			do {
				double currentBurstTime = process.getNextBurstTime();
				System.out.printf("process %d has CPU burst %f.\n", process.getId(), currentBurstTime);
				currentTime += currentBurstTime;
			} while (process.hasMoreBurst());
			System.out.printf("process %d completes and terminates at %f.\n", process.getId(), currentTime);
		}

		System.out.println("Simulation summary");
		System.out.printf("CPU idle time: %f\n", idleTime);
		System.out.printf("CPU utilization percentage: %f\n", (currentTime - idleTime) / currentTime);
		System.out.println("Signature name: " + queue.getSignature());
	}

	public static void main(String[] args) {
		ProcessFactory factory = new ProcessFactory();
		List<Process> processList = factory.batchGenerate();
		processList.forEach(p -> queue.offer(p));
		executeProcesses();
	}
}
