package java_20190617.exchoclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient1 {
	private String ip;
	private int port;
	private Socket socket;

	public EchoClient1(String ip, int port) {
		this.ip = ip;
		this.port = port;

		try {
			// 3.4. Ŭ���̾�Ʈ Socket ��ü�� �����Ѵ�.
			socket = new Socket(ip, port);

			// 4. 5. ������ TCP ���ؼ��� ��������鼭 Ŭ���̾�Ʈ�� ����� �� �ִ� Socket ��ü�� �����ȴ�.

			// 6. �޼����� ������.
			OutputStream out = socket.getOutputStream();

			// 6-1
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("�ȳ��ϼ���!");
			bw.newLine();
			bw.flush();

			// 9. Ŭ���̾�Ʈ�� ���� �޼����� �޴´�.
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String readLine = br.readLine();
			System.out.println(readLine);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoClient1("192.168.0.161", 8080);
	}
}
