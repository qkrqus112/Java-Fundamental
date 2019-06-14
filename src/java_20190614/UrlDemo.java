package java_20190614;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://sports.news.naver.com/wfootball/news/read.nhn?oid=450&aid=0000052061");
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		System.out.println("protocol : " + protocol);
		System.out.println("host : " + host);
		System.out.println("port : " + port);
		System.out.println("path : " + path);
		System.out.println("query : " + query);
		System.out.println("ref : " + ref);

		InputStream in = url.openStream();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		String readLine = null;
		while((readLine = br.readLine()) != null){
			System.out.println(readLine);
		}

	}
}
