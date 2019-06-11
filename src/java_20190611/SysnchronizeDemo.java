package java_20190611;

public class SysnchronizeDemo implements Runnable {
	int x, y;

	@Override
	public void run() {
		synchronized (SysnchronizeDemo.class) {
			for (int i = 0; i < 9; i++) {
				x++;
				y++;
				String threadName = Thread.currentThread().getName();
				System.out.printf("x : %d, y : %d -%s\n", x, y, threadName);
			}
		}
	}

	public static void main(String[] args) {
		SysnchronizeDemo s1 = new SysnchronizeDemo();
		Thread t1 = new Thread(s1);
		t1.start();
		SysnchronizeDemo s2 = new SysnchronizeDemo();
		Thread t2 = new Thread(s1);
		t2.start();	
	}
}
