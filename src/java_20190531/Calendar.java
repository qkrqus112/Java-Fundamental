package java_20190531;

public class Calendar {
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESEDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	// isLeafYear는 윤년인지 아닌지를 판단하는 메서드 매개변수가 윤년이면 true, 아니면 false
	private boolean isLeafYear(int year) {
		boolean isLeafYear = false;
		if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			isLeafYear = true;
		}
		return isLeafYear;
	}
	


	// 1년, 1월, 1일부터 ~ 년, 월, 일의 총일수를 구하는 메서드
	private int getCount(int year, int month, int day) {
		// 총일수 구할때는 년도는 이전년도까지 일수를 구해야 하기 때문에 preYear 변수를 설정
		int preYear = year - 1;
		// 해당 년도의 이전달을 저장하기 위한 변수
		int preMonth = month - 1;
		int totalCnt;

		// 2018년도 일 수 구하기
		totalCnt = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < preMonth; i++) {
			totalCnt += monthArray[i];
		}

		// 해당 년도가 윤년인지 판단하고 유년인 경우 3월 이상이면 1을 추가함
		if (month >= 3 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			totalCnt++;
		}

		totalCnt += day;

		return totalCnt;
	}

	// 년도의 매월 마지막 날짜를 구하는 메서드
	private int getLastDay(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (isLeafYear(year)) {
			// 윤년이면 2월을 29일로 바꿔야 한다.
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

		System.out.println(year + "년 " + month + "월 달력 입니다.");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		// 시작날짜
		int start = 1;

		// 마지막날짜
		int end = getLastDay(year, month);

		// 요일을 구함.
		int rest = getCount(year, month, 1) % 7;

		// 월요일이면 rest => 1
		// 화요일이면 rest => 2
		// 수요일이면 rest => 3
		// 목요일이면 rest => 4
		// 금요일이면 rest => 5
		// 토요일이면 rest => 6
		// 일요일이면 rest => 0

		// 요일수 만큰 탬 처리
		for (int i = 0; i < rest; i++) {
			System.out.print("\t");
		}
		for (int i = start; i <= end; i++) {
			System.out.print(i + "\t");

			// 요일 증가
			rest++;

			// rest가 7이되면 개행을 해준다.
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
			dayOfWeek = "월요일";
			break;
		case Calendar.TUESEDAY:
			dayOfWeek = "화요일";
			break;
		case Calendar.WEDNESDAY:
			dayOfWeek = "수요일";
			break;
		case Calendar.THURSDAY:
			dayOfWeek = "목요일";
			break;
		case Calendar.FRIDAY:
			dayOfWeek = "금요일";
			break;
		case Calendar.SATURDAY:
			dayOfWeek = "토요일";
			break;
		case Calendar.SUNDAY:
			dayOfWeek = "일요일";
			break;
		}

		System.out.println(year + "년 " + month + "월 " + day + "일 " + dayOfWeek + "입니다. ");

	}

}
