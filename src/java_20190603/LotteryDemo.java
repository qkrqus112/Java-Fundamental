package java_20190603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LotteryDemo {

	public static String console() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) throws IOException {
		Lottery lottery = new Lottery();
		int[] temp = new int[6];
		while (true) {
			System.out.print("로또복권 개수를 입력하세요 > ");
			String readLine = console();
			if (readLine.equals("bye"))
				break;
			int count = Integer.parseInt(readLine);

			for (int i = 0; i < count; i++) {
				lottery.process();
			}
		}

	}
}
