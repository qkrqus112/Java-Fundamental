package java_20190611;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:\\down\\1560232415475.exe");
			FileOutputStream fos = new FileOutputStream("c:\\down\\2019\\1560232415475.exe");

			int readByte = 0;
			while ((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
