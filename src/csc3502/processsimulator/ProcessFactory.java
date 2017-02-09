package csc3502.processsimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessFactory {

	private int id = 1;
	private double arrivalTime = 0;
	private static final int MAX_PRIORITY = 5;
	private static final int MIN_PRIORITY = 1;

	// setting parameters
	private double maxBurst = 60;
	private double minBurst = 10;
	private double mean = 50;
	private double stdDeviance = 30;
	private int numOfProcess = 100;

	public ProcessFactory() {
	}

	public ProcessFactory(double mean, double stdDeviance, double maxBurst, double minBurst, int numOfProcess) {
		this.mean = mean;
		this.stdDeviance = stdDeviance;
		this.maxBurst = maxBurst;
		this.minBurst = minBurst;
		this.numOfProcess = numOfProcess;
	}

	public List<Process> batchGenerate() {
		List<Process> processList = new ArrayList<>();
		for (int i = 0; i < numOfProcess; i++) {
			processList.add(generate());
		}
		return processList;
	}

	public Process generate() {
		return new Process(getId(), getArrivalTime(), getPriority(), maxBurst, minBurst);
	}

	private int getId() {
		return id++;
	}

	private double getArrivalTime() {
		arrivalTime += new Random().nextGaussian() * stdDeviance + mean;
		return arrivalTime;
	}

	private int getPriority() {
		return new Random().nextInt(MAX_PRIORITY - MIN_PRIORITY + 1) + MIN_PRIORITY;
	}

}
