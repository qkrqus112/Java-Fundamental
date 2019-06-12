package java_20190612;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIntputOutoutTestDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try

		{
			fis = new FileInputStream("c:\\down\\jdk.exe");
			fos = new FileOutputStream("c:\\down\\2019\\jdk.exe");

			long start = System.currentTimeMillis();

			int readByteCount = 0;
			byte[] readBytes = new byte[10240 * 4];
			while ((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}

			long end = System.currentTimeMillis();

			System.out.println("경과시간 : " + (end - start));
		} catch (IOException e)

		{
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
