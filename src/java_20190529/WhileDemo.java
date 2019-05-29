package java_20190529;

public class WhileDemo {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		int j = 1;
		
		
		while (i <= 100) {
			if (i % 2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("1부터 " + (i - 1) + " 까지 짝수 합은 : " + sum);

		while (j < 10) {
			int k = 1;
			while (k < 10) {
				System.out.println(j + " * " + k + " = " + j * k);
				k++;
			}
			j++;
		}
	}
}