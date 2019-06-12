package java_20190611;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// FileInputStream의 c:\\down\\jdk.exe 경로에 파일이 없으면
			// FileNotFoundException 예외를 발생시킨다.
			fis = new FileInputStream("c:\\down\\eclipse-jee-mars-R-win32-x86_64.zip");

			// FileOutputStream은 C:\\down\\2019\\06\\11\\jdk.exe
			// 위의 경로에 파일을 생성해주고 FileNotFoundException 예외를 발생시킨다.
			fos = new FileOutputStream("C:\\down\\2019\\eclipse-jee-mars-R-win32-x86_64.zip");

			// int readByte = 0;
			// fis.read() 메서드는 한 바이트씩 읽는다.
			// 만약 더이상 읽을 바이트가 없으면 -1를 반환한다.
			// while ((readByte = fis.read()) != -1) {
			// fos.writer(readByte) 메서드는 한 바이트씩 씀
			// fos.write(readByte);
			// }

			long start = System.currentTimeMillis();

			int readByteCount = 0;
			byte[] readBytes = new byte[10240*4];
			while ((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}

			long end = System.currentTimeMillis();

			System.out.println("경과시간 : " + (end - start));

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
