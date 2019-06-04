package java_20190604.Step5;

public class StopWatchDemo {
	// 추상클래스의 다형성
	public static void execute(StopWatch sm) {
		sm.start();

		for (int i = 0; i < 2_000_000_000l; i++) {
		}
		sm.stop();
		System.out.println("경과시간 : " + sm.getElapsedTime());
	}

	public static void main(String[] args) {

		StopMilliWatch sm = new StopMilliWatch();
		execute(sm);

		StopNanoWatch sn = new StopNanoWatch();
		execute(sn);
		
		StopMicroWatch smw = new StopMicroWatch();
		execute(smw);
		
	}
}
