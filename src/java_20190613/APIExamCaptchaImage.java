package java_20190613;

//���̹� ĸ�� API ���� - ĸ�� �̹��� ����
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class APIExamCaptchaImage {

 public static void main(String[] args) {
     String clientId = "dckJwwt62tonM98p0Rs2";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
     String clientSecret = "Yj3ywPVqG2";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
     try {
         String key = "ySPhh9q45Z76GWbS"; // https://openapi.naver.com/v1/captcha/nkey ȣ��� ���� Ű��
         String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("GET");
         con.setRequestProperty("X-Naver-Client-Id", clientId);
         con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
         int responseCode = con.getResponseCode();
         BufferedReader br;
         if(responseCode==200) { // ���� ȣ��
             InputStream is = con.getInputStream();
             int read = 0;
             byte[] bytes = new byte[1024];
             // ������ �̸����� ���� ����
             String tempname = String.valueOf(new Date().getTime());
             File f = new File("c:\\down\\"+tempname + ".jpg");
             //f.createNewFile();
             FileOutputStream outputStream = new FileOutputStream(f);
             while ((read =is.read(bytes)) != -1) {
                 outputStream.write(bytes, 0, read);
             }
             is.close();
             outputStream.close();
         } else {  // ���� �߻�
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
             String inputLine;
             StringBuffer response = new StringBuffer();
             while ((inputLine = br.readLine()) != null) {
                 response.append(inputLine);
             }
             br.close();
             System.out.println(response.toString());
         }
     } catch (Exception e) {
         System.out.println(e);
     }
 }
}
