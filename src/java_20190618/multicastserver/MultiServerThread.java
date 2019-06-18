package java_20190618.multicastserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServerThread implements Runnable {
	private Socket socket;
	private ArrayList<MultiServerThread> list;
	private PrintWriter pw;

	public MultiServerThread(Socket socket, ArrayList<MultiServerThread> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean isStop = false;
		BufferedReader br = null;

		try {
			InputStream in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			OutputStream out = socket.getOutputStream();
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)), true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!isStop) {
			try {
				String readLine = br.readLine();
				if (readLine != null && readLine.equals("exit")) {
					isStop = true;
					sendMessage("exit");
					list.remove(this);
					System.out.println(readLine);
					System.out.println("list size : " + list.size());
				} else {
					broadCast(readLine);
					System.out.println(readLine);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("������ ������ ������.. ������...");
				isStop = true;
				list.remove(this);
				System.out.println("list size : " + list.size());
			}
		}

		try {
			if (br != null)
				br.close();
			if (pw != null)
				pw.close();
			if (socket != null)
				socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void broadCast(String message) {
		for (int i = 0; i < list.size(); i++) {
			MultiServerThread mst = list.get(i);
			mst.sendMessage(message);
		}
	}

	public void sendMessage(String message) {
		pw.println(message);
	}

}
