package java_20190617.echoserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer1 {
	private int port;
	private ServerSocket serverSocket;

	public EchoServer1(int port) {

		this.port = port;

		try {
			// 1 ServerSocket ��ü�� ����
			serverSocket = new ServerSocket(port);

			// 2 ServerSocket�� accept() �޼���� Ŭ���̾�Ʈ ������ ����Ѵ�.
			Socket socket = serverSocket.accept();
			InetAddress ia = socket.getInetAddress();
			String ip = ia.getHostAddress();
			System.out.println(ip + "�����߽��ϴ�.");

			// 4.5. Ŭ���̾�Ʈ�� TCP ���ؼ��� ��������鼭 Ŭ���̾�Ʈ�� ����� �� �ִ� Socket ��ü�� �����ȴ�.

			// 7. Ŭ���̾�Ʈ�� ���� �޼����� �޴´�.
			InputStream in = socket.getInputStream();

			// 7-1
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String readLine = br.readLine();
			System.out.println(readLine);

			// 8. ���� �޼����� Ŭ���̾�Ʈ���� �ٽ� ������.
			OutputStream out = socket.getOutputStream();

			// 8-1
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(readLine);
			bw.newLine();
			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new EchoServer1(3001);
	}

}
