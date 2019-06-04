package java_20190604.Step5;

public class StopMicroWatch extends StopWatch {

	public void start() {
		startTime = System.nanoTime();
	}

	public void stop() {
		endTime = System.nanoTime();
	}

	public double getElapsedTime() {
		return (double) (endTime - startTime) / (double) 1000000000;

	}

}
