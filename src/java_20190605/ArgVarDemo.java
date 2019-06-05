package java_20190605;

public class ArgVarDemo {
	public int sum(int... temp) {
		int sum = 0;

		/*
		 * for (int i = 0; i < temp.length; i++) { sum += temp[i]; }
		 */

		for (int value : temp) {
			sum += value;
		}
		return sum;
	}

	public static void main(String[] args) {
		ArgVarDemo d = new ArgVarDemo();

		int a = d.sum(1, 2, 3, 4, 5, 6);
		System.out.println(a);

	}

}
