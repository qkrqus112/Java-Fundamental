package java_20190604.Step1;

public class FootStopWatch2 {
	public long startTime;
	public long endTime;

	public long startNanoTime;
	public long endNanoTime;

	public double getElapsedTime() {
		return (double) (endTime - startTime) / (double) 1000;
	}

	public double getElapsedNanoTime() {
		return (double) (endNanoTime - startNanoTime) / (double) 1000000000;
	}

	public static void main(String[] args) {
		FootStopWatch2 f = new FootStopWatch2();
		f.startNanoTime = System.nanoTime();
		for (int i = 0; i < 2_000_000_000l; i++) {

		}
		f.endNanoTime = System.currentTimeMillis();
		double elapsedNanoTime = f.getElapsedNanoTime();

		System.out.println("경과 시간(나노) : " + elapsedNanoTime);
	}
}
