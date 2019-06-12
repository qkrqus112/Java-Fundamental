package java_20190612;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;

		try {
			fis = new FileInputStream("c:\\down\\eclipse.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("c:\\down\\2019\\eclipse.zip");
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos, true); // true => autoFlush

			int readByteCount = 0;
			byte[] readBytes = new byte[2014];
			while ((readByteCount = bis.read(readBytes)) != -1) {
				ps.write(readBytes, 0, readByteCount);
			}
			
			//PrintStream의 목적지가 모니터
			PrintStream ps1 = System.out;
			ps1.println(1);
			ps1.println("aaaa");
			ps1.println(42.5);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
