package java_20190612;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InpurStreamReaderDemo {
	public static void main(String[] args) {
		InputStream in = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			// Ű����� �Է��� ����. �ٽø��ؼ� InputStream�� ����� �� Source(���)�� Ű������ ���

			fw = new FileWriter("c:\\down\\temp.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			boolean isStop = false;
			while (!isStop) {
				in = System.in;
				// 1����Ʈ �Է� ��Ʈ���� 2����Ʈ �Է� ��Ʈ������ ��ȯ
				ir = new InputStreamReader(in);
				br = new BufferedReader(ir);
				System.out.print("�Է��ϼ��� >");

				String readLine = br.readLine();
				if (readLine.equals("exit")) {
					isStop = true;
				} else {
					pw.println(readLine);
				}
			}
		} catch (

		IOException e)

		{
			// TODO: handle exception
			e.printStackTrace();
		} finally

		{
			try {
				if (in != null) {
					in.close();
				}
				if (ir != null) {
					ir.close();
				}
				if (br != null) {
					br.close();
				}
				if (fw != null) {
					fw.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
