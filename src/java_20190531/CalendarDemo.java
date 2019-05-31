package java_20190531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalendarDemo {
	// 키보드로 입력받은 한줄을 반환하는 함수
	public static String console() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) throws IOException {
		Calendar c = null;

		while (true) {
			System.out.print("날짜를 입력하세요 > ");
			String readLine = console();
			if (readLine.equals("bye"))
				break;
			// readLin => 2019 5 31
			// split(" ") 공백문자로 문자열을 분리해서 배열로 반환
			//data[0] = "2019", data[1] = "5", data[2] = "31"
			String[] data = readLine.split(" ");
			
			//Calendar 객체를 생성해서 아래의 모든 경우에 사용한다.
			c = new Calendar();
			
			if (data.length == 1) {
				//year = 2019;
				//Integer.parseInt("2019") => 2019
				//Integer.parseInt() 메서드는 문자열을 int로 변환하는 메서드
				int year = Integer.parseInt(data[0]);
				c.print(year);

			} else if (data.length == 2) {
				int year = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				c.print(year, month);

			} else if (data.length == 3) {
				int year = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				int day = Integer.parseInt(data[2]);
				c.print(year, month, day);

			}
		}
	}

}
