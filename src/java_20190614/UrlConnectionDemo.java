package java_20190614;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL(
				"https://www.google.co.kr/search?source=hp&ei=2lYDXfubMoyH8wWQy6T4Bw&q=dfdf&oq=dfdf&gs_l=psy-ab.3..0l5j0i10j0l4.22457.22718..22817...0.0..0.94.439.7......0....1..gws-wiz.....0..0i131.FQWPYbyZT30");
		URLConnection urlCon = url.openConnection();

		String server = urlCon.getHeaderField("server");
		String cacheControl = urlCon.getHeaderField("Cache-Control");
		String expires = urlCon.getHeaderField("Expires");
		String contentType = urlCon.getHeaderField("Content-Type");
		String location = urlCon.getHeaderField("Location");
		String connection = urlCon.getHeaderField("Connection");
		String setCookie = urlCon.getHeaderField("Set-Cookie");
		int len = urlCon.getContentLength();

		System.out.println("Server : " + server);
		System.out.println("Cache-Control : " + cacheControl);
		System.out.println("Expires : " + expires);
		System.out.println("Content-Type : " + contentType);
		System.out.println("Location : " + location);
		System.out.println("Connection : " + connection);
		System.out.println("Set-Cookie : " + setCookie);
		System.out.println("len : " + len);

		InputStream in = urlCon.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			System.out.println(readLine);
		}
	}
}
