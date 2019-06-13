package java_20190613;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.chrono.IsoChronology;
import java.util.Date;

public class NaverCaptcha {
	public String getKey(){
		StringBuffer response = new StringBuffer();
		String clientId = "dckJwwt62tonM98p0Rs2";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
		String clientSecret = "Yj3ywPVqG2";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";
		try {
			String code = "0"; // Ű �߱޽� 0, ĸ�� �̹��� �񱳽� 1�� ����
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // ���� ȣ��
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // ���� �߻�
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return response.toString();
	}
	public boolean isCreateImage(String key){
		boolean isSuccess = false;
		String clientId = "dckJwwt62tonM98p0Rs2";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
		String clientSecret = "Yj3ywPVqG2";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";
		try {
			//String key = "ySPhh9q45Z76GWbS"; // https://openapi.naver.com/v1/captcha/nkey
												// ȣ��� ���� Ű��
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // ���� ȣ��
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];
				// ������ �̸����� ���� ����
				String tempname = String.valueOf(new Date().getTime());
				File f = new File("c:\\down\\" + tempname + ".jpg");
				// f.createNewFile();
				FileOutputStream outputStream = new FileOutputStream(f);
				while ((read = is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				is.close();
				outputStream.close();
				isSuccess = true;
			} else { // ���� �߻�
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				//System.out.println(response.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return isSuccess;
	}
	public String getResult(String key, String value){
		StringBuffer response = new StringBuffer();
		String clientId = "dckJwwt62tonM98p0Rs2";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
		String clientSecret = "Yj3ywPVqG2";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";
		try {
			String code = "1"; // Ű �߱޽� 0, ĸ�� �̹��� �񱳽� 1�� ����
			//String key = "ySPhh9q45Z76GWbS"; // ĸ�� Ű �߱޽� ���� Ű��
			//String value = "f8va725"; // ����ڰ� �Է��� ĸ�� �̹��� ���ڰ�
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code + "&key=" + key + "&value="
					+ value;

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // ���� ȣ��
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // ���� �߻�
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return response.toString();
	}
	
	public static void main(String[] args) {
		NaverCaptcha n = new NaverCaptcha();
		//String key = n.getKey();
		String key = "lQnZPA2gj3jWYW8a";
		/*System.out.println(key);
		if(n.isCreateImage(key)){
			System.out.println("�̹��� ���� ����");
			
		}else{
			System.out.println("�̹��� ���� ����");
		}*/
		
		String value = "639c";
		String result = n.getResult(key, value);
		System.out.println(result);
		
	}
	
}














