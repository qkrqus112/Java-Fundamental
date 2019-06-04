package java_20190604.Step2;

public class StopWatch {
	public long startTime;
	public long endTime;

	public double getElapsedTime() {
		return (double) (endTime - startTime) / (double) 1000;
	}

	public double getElapsedNanoTime() {
		return (double) (endTime - startTime) / (double) 1000000000;
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}

	public void startNano() {
		startTime = System.nanoTime();
	}

	public void stopNano() {
		endTime = System.nanoTime();
	}

}
