package java_20190531;

public class Calendar {
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESEDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	// isLeafYear�� �������� �ƴ����� �Ǵ��ϴ� �޼��� �Ű������� �����̸� true, �ƴϸ� false
	private boolean isLeafYear(int year) {
		boolean isLeafYear = false;
		if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			isLeafYear = true;
		}
		return isLeafYear;
	}
	


	// 1��, 1��, 1�Ϻ��� ~ ��, ��, ���� ���ϼ��� ���ϴ� �޼���
	private int getCount(int year, int month, int day) {
		// ���ϼ� ���Ҷ��� �⵵�� �����⵵���� �ϼ��� ���ؾ� �ϱ� ������ preYear ������ ����
		int preYear = year - 1;
		// �ش� �⵵�� �������� �����ϱ� ���� ����
		int preMonth = month - 1;
		int totalCnt;

		// 2018�⵵ �� �� ���ϱ�
		totalCnt = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < preMonth; i++) {
			totalCnt += monthArray[i];
		}

		// �ش� �⵵�� �������� �Ǵ��ϰ� ������ ��� 3�� �̻��̸� 1�� �߰���
		if (month >= 3 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			totalCnt++;
		}

		totalCnt += day;

		return totalCnt;
	}

	// �⵵�� �ſ� ������ ��¥�� ���ϴ� �޼���
	private int getLastDay(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (isLeafYear(year)) {
			// �����̸� 2���� 29�Ϸ� �ٲ�� �Ѵ�.
			monthArray[1] = 29;
		}
		return monthArray[month - 1];
	}

	public void print(int year) {
		// TODO Auto-generated method stub

		for (int a = 1; a <= 12; a++) {
			print(year, a);
		}
		System.out.println();
	}

	public void print(int year, int month) {
		// TODO Auto-generated method stub

		System.out.println(year + "�� " + month + "�� �޷� �Դϴ�.");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		// ���۳�¥
		int start = 1;

		// ��������¥
		int end = getLastDay(year, month);

		// ������ ����.
		int rest = getCount(year, month, 1) % 7;

		// �������̸� rest => 1
		// ȭ�����̸� rest => 2
		// �������̸� rest => 3
		// ������̸� rest => 4
		// �ݿ����̸� rest => 5
		// ������̸� rest => 6
		// �Ͽ����̸� rest => 0

		// ���ϼ� ��ū �� ó��
		for (int i = 0; i < rest; i++) {
			System.out.print("\t");
		}
		for (int i = start; i <= end; i++) {
			System.out.print(i + "\t");

			// ���� ����
			rest++;

			// rest�� 7�̵Ǹ� ������ ���ش�.
			if (rest % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();

	}

	public void print(int year, int month, int day) {
		// TODO Auto-generated method stub

		int totalCnt = getCount(year, month, day);
		int rest = totalCnt % 7;
		String dayOfWeek = "";
		switch (rest) {
		case Calendar.MONDAY:
			dayOfWeek = "������";
			break;
		case Calendar.TUESEDAY:
			dayOfWeek = "ȭ����";
			break;
		case Calendar.WEDNESDAY:
			dayOfWeek = "������";
			break;
		case Calendar.THURSDAY:
			dayOfWeek = "�����";
			break;
		case Calendar.FRIDAY:
			dayOfWeek = "�ݿ���";
			break;
		case Calendar.SATURDAY:
			dayOfWeek = "�����";
			break;
		case Calendar.SUNDAY:
			dayOfWeek = "�Ͽ���";
			break;
		}

		System.out.println(year + "�� " + month + "�� " + day + "�� " + dayOfWeek + "�Դϴ�. ");

	}

}
