package java_20190528;

public class ForDemo {
	public static void main(String[] args) {
		// int sum = 0;
		// int i = 1;

		/*
		 * for (; i <= 100; i++) { if (i % 2 == 1) { sum = sum + i; } }
		 * System.out.println("1부터 " + (i - 1) + " 까지  짝수의 합은 : " + sum); }
		 */

		tt: for (int j = 1; j <= 9; j++) {
			if (j == 3)
				continue;
			for (int k = 1; k <= 9; k++) {
				if (k == 4)
					break tt;
				System.out.println(j + " * " + k + " = " + j * k);
			}
		}
		/*
		 * int primeCnt = 0; for (int i = 1; i <= 100; i++) { int cnt = 0; for
		 * (int j = 1; j <= i; j++) { if (i % j == 0) { cnt++; } } if (cnt == 2)
		 * { System.out.println(i + "는 소수"); primeCnt++; } } System.out.println(
		 * "소수의 개수는 : " + primeCnt);
		 */
	}
}
