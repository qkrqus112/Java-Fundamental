package java_20190604.Step3;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopMilliWatch sm = new StopMilliWatch();
		sm.start();

		for (int i = 0; i < 2_000_000_000l; i++) {

		}
		sm.stop();
		System.out.println("����ð�(�и�������) : " + sm.getElapsedTime());

		StopNanoWatch sn = new StopNanoWatch();

		sn.start();
		for (int i = 0; i < 2_000_000_000l; i++) {

		}
		sn.stop();
		System.out.println("����ð�(���뼼����) : " + sn.getElapsedTime());
	}
}
