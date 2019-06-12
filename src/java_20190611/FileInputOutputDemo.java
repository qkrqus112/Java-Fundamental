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
			// FileInputStream�� c:\\down\\jdk.exe ��ο� ������ ������
			// FileNotFoundException ���ܸ� �߻���Ų��.
			fis = new FileInputStream("c:\\down\\eclipse-jee-mars-R-win32-x86_64.zip");

			// FileOutputStream�� C:\\down\\2019\\06\\11\\jdk.exe
			// ���� ��ο� ������ �������ְ� FileNotFoundException ���ܸ� �߻���Ų��.
			fos = new FileOutputStream("C:\\down\\2019\\eclipse-jee-mars-R-win32-x86_64.zip");

			// int readByte = 0;
			// fis.read() �޼���� �� ����Ʈ�� �д´�.
			// ���� ���̻� ���� ����Ʈ�� ������ -1�� ��ȯ�Ѵ�.
			// while ((readByte = fis.read()) != -1) {
			// fos.writer(readByte) �޼���� �� ����Ʈ�� ��
			// fos.write(readByte);
			// }

			long start = System.currentTimeMillis();

			int readByteCount = 0;
			byte[] readBytes = new byte[10240*4];
			while ((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}

			long end = System.currentTimeMillis();

			System.out.println("����ð� : " + (end - start));

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
