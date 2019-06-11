package java_20190611;

import java.io.File;
import java.util.Calendar;

public class FileDemo {
	public boolean mkdir(String path) {
		boolean isSuccess = false;
		File f1 = new File(path);
		boolean isExisted = f1.isDirectory();
		if (!isExisted) {
			isSuccess = f1.mkdirs();
		}
		return isSuccess;
	}

	public String getComma(int number) {
		return String.format("%,d", number);
	}

	public String getComma(long number) {
		return String.format("%,d", number);
	}

	public String getComma(double number, int precision) {
		return String.format("%,." + precision + "f", number);
	}

	public String getComma(double number) {
		return String.format("%,f", number);
	}

	public static void main(String[] args) {
		FileDemo f = new FileDemo();
		// f.mkdir("c:\\down2\\2019\\06\\11");

		File f1 = new File("c:\\down", "Git-2.21.0-64-bit.exe");
		long fileSize = f1.length();
		String fileLength = f.getComma(Math.round((double) fileSize / 1024));
		// System.out.println(fileLength + "KB");

		String fileName = f1.getName();
		String path = f1.getPath();

		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String extension = fileName.substring(fileName.lastIndexOf("."));
		name = String.valueOf(System.currentTimeMillis());
		name += extension;
		// System.out.println(name);
		// System.out.println(extension);
		File f2 = new File("c:\\down", name);
		f1.renameTo(f2);

		File f3 = new File("c:\\");
		String[] list = f3.list();
		for (String value : list) {
			File f4 = new File(f3, value);
			if (f4.isDirectory()) {
				System.out.println(value + "- 디렉토리");
			} else if (f4.isFile()) {
				long size = f4.length();
				System.out.println(value + "- 파일(" + size + ")");
			}

		}

		File f5 = new File("C:\\down\\jre-8u211-windows-x64.exe");
		long lastModified = f5.lastModified();
		Calendar c = Calendar.getInstance();

		c.setTimeInMillis(lastModified);

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		System.out.print(year + "년 " + month + "월 " + date + "일 ");

		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case Calendar.MONDAY:
			System.out.println("월요일 입니다.");
			break;
		case Calendar.TUESDAY:
			System.out.println("화요일 입니다.");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("수요일 입니다.");
			break;
		case Calendar.THURSDAY:
			System.out.println("목요일 입니다.");
			break;
		case Calendar.FRIDAY:
			System.out.println("금요일 입니다.");
			break;
		case Calendar.SATURDAY:
			System.out.println("토요일 입니다.");
			break;
		case Calendar.SUNDAY:
			System.out.println("일요일 입니다.");
			break;
		}
	}

}
