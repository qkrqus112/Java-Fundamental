package java_20190529;

public class CalenderDemo {
	public static void main(String[] args) {
		
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int date = Integer.parseInt(args[2]);

		int preYear = year - 1;
		int preMonth = month - 1;
		int totalCnt;

		totalCnt = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < preMonth; i++) {
			totalCnt += monthArray[i];
		}

		// 해당 년도가 윤년인지 판단하고 유년인 경우 3월 이상이면 1을 추가함
		if (month >= 3 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			totalCnt++;
		}

		totalCnt += date;
		int rest = totalCnt % 7;
		String day = "";
		switch (rest) {
			case 1:day = "월요일";	break;
			case 2:day = "화요일";	break;
			case 3:day = "수요일";	break;
			case 4:day = "목요일";	break;
			case 5:day = "금요일";	break;
			case 6:day = "토요일";	break;
			case 0:day = "일요일";	break;
		}
		
		System.out.println(year + "년 " + month + "월 " + date + "일 " + day + "입니다. ");

	}
}
