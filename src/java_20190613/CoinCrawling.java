package java_20190613;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CoinCrawling {

	static HSSFRow row;
	static HSSFCell cell;

	public static void main(String[] args) throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("비트코인");
		HSSFRow row = null;
		HSSFCell cell = null;

		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20190101&end=20190613";
		Document doc = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {

		}

		// headElements는 정보 가져오기 위한 Elements
		// bodyElements는 실데이터 정보를 가져오기 위한 Elements
		Elements headElements = doc.select(".table-responsive .table thead tr");
		Elements bodyElements = doc.select(".table-responsive .table tbody tr");

		for (int i = 0; i < headElements.size(); i++) {
			row = sheet.createRow(0);
			Element e = (Element) headElements.get(i);
			String date = e.child(0).text();
			cell = row.createCell(0);
			cell.setCellValue(date);

			String open = e.child(1).text();
			cell = row.createCell(1);
			cell.setCellValue(open);

			String high = e.child(2).text();
			cell = row.createCell(2);
			cell.setCellValue(high);

			String low = e.child(3).text();
			cell = row.createCell(3);
			cell.setCellValue(low);

			String close = e.child(4).text();
			cell = row.createCell(4);
			cell.setCellValue(close);

			String volume = e.child(5).text();
			cell = row.createCell(5);
			cell.setCellValue(volume);

			String marketCap = e.child(6).text();
			cell = row.createCell(6);
			cell.setCellValue(marketCap);

			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s", date, open, high, low, close, volume, marketCap);
			System.out.printf("\n");
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 1000);

		}

		for (int i = 0; i < bodyElements.size(); i++) {
			row = sheet.createRow(i + 1);
			Element e = (Element) bodyElements.get(i);
			String date = e.child(0).text();
			cell = row.createCell(0);
			cell.setCellValue(date);

			String open = e.child(1).text();
			cell = row.createCell(1);
			cell.setCellValue(open);

			String high = e.child(2).text();
			cell = row.createCell(2);
			cell.setCellValue(high);

			String low = e.child(3).text();
			cell = row.createCell(3);
			cell.setCellValue(low);

			String close = e.child(4).text();
			cell = row.createCell(4);
			cell.setCellValue(close);

			String volume = e.child(5).text();
			cell = row.createCell(5);
			cell.setCellValue(volume);

			String marketCap = e.child(6).text();
			cell = row.createCell(6);
			cell.setCellValue(marketCap);

			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s", date, open, high, low, close, volume, marketCap);
			System.out.printf("\n");
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 1000);
		}

		try {
			FileOutputStream fileoutputstream = new FileOutputStream("c:\\down\\123.xls\\");
			workbook.write(fileoutputstream);
			fileoutputstream.close();
			System.out.println("엑셀파일생성성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("엑셀파일생성실패");
		}

	}
}
