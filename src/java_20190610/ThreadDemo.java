package java_20190610;

public class ThreadDemo extends Thread {
	public ThreadDemo(String msg) {
		super(msg);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " : " + i);
		}
	}

	public static void main(String[] args) {
		System.out.println("***************start*******************");
		ThreadDemo t1 = new ThreadDemo("첫번째 쓰레드");
		t1.start();
		ThreadDemo t2 = new ThreadDemo("두번째 쓰레드");
		t2.start();
		ThreadDemo t3 = new ThreadDemo("세번째 쓰레드");
		t3.start();
		ThreadDemo t4 = new ThreadDemo("네번째 쓰레드");
		t4.start();
		ThreadDemo t5 = new ThreadDemo("다섯번째 쓰레드");
		t5.start();
		System.out.println("***************end*******************");
		
	}
}
