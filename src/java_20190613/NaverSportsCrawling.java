package java_20190613;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverSportsCrawling {
	public static void main(String[] args) {
		// String url = "https://sports.naver.com/kfootball/index.nhn";
		//
		// Document doc = null;
		//
		// try {
		// doc = Jsoup.connect(url).get();
		// } catch (IOException e) {
		//
		// }
		//
		// Elements elements = doc.select(".home_news");
		//
		// String title = elements.select("h2").text().substring(0, 4);
		// System.out.println(title);
		//
		// for (Element temp : elements.select("li")) {
		// System.out.println(temp.text());
		// }

		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20190101&end=20190613";

		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {

		}

		Elements elements = doc.select(".padding-top-1x");

		String title = elements.select("thead").text();
		System.out.println(title);
		

		for (Element temp : elements.select(".text-right")) {
			System.out.println(temp.text());
		}

	}
}
