package java_20190603;

public class Lottery {

	public void print(int count) {

	}

	public static void process() {
		int[] temp = new int[6];
		for (int i = 0; i < temp.length; i++) {
			int random = (int) (Math.random() * 45) + 1;
			temp[i] = random;
			for (int j = 0; j < i; j++) {
				if (temp[j] == temp[i]) {
					temp[i] = random;
					i--;
				}
			}
		}
		for (int value : temp) {
			System.out.print(value + "\t");
		}
		System.out.println();
	}

}
