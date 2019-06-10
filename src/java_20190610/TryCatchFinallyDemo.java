package java_20190610;

public class TryCatchFinallyDemo {
	public static double average(int a, int b) {
		int sum = a + b;
		return (double) sum / (double) 2;
	}

	public static void main(String[] args) {
		/*
		 * if (args.length != 2) { System.err.println(
		 * "usage : java TryCatchFinallyDemo [��������] [��������]"); // return; }
		 */

		// Integer.parsInt() �޼���� ���ڰ� �ƴ� ���ڿ��� ��� ��, �Ϲ� ���ڿ��� ���
		// NumberFormatException ���ܰ� �߻���

		try {
			// ArrayIndexOutOfBoundsException
			int korea = Integer.parseInt(args[0]);

			// JVM�� ������ ���� ��Ű��, ���� ��ü�� NumberFormatException ��ü�� ������ ��
			// catch ���� ã�´�.
			int english = Integer.parseInt(args[1]);
			double avg = average(korea, english);
			System.out.printf("��� : %.2f\n", avg);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			// System.err.println("���� �޼��� : " + e.getMessage());
			System.err.println("���ڸ��� ���ڸ� �־�!");
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			// System.err.println("���� �޼��� : " + e.getMessage());
			// System.err.println("���ڸ��� ���ڸ� �־�!");
			System.err.println("usage : java TryCatchFinallyDemo [��������] [��������]");
		} finally {
			System.out.println("finally block");
		}

	}
}
