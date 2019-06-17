package java_20190617.exchoclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.omg.CORBA.portable.UnknownException;

public class EchoClient2 {
	private String ip;
	private int port;
	private Socket socket;

	public EchoClient2(String ip, int port) {
		this.ip = ip;
		this.port = port;

		try {
			socket = new Socket(ip, port);

			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("¾È³ç");
			bw.newLine();
			bw.flush();

			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String readLine = br.readLine();
			System.out.println(readLine);

		} catch (UnknownException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new EchoClient2("192.168.0.161", 3002);
	}
}
