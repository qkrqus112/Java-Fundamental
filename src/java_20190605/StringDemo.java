package java_20190605;

public class StringDemo {
	public static void main(String[] args) {
		String str1 = new String("test");
		String str2 = new String("test");

		String str3 = "java";
		String str4 = "java";

		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));

		String ssn = "234567-8923456";
		// charAt(int index) �޼���� ���ڿ��߿��� Ư�� index�� �ִ� ���ڸ� ��ȯ�Ѵ�.
		char c = ssn.charAt(6);
		System.out.println(c);

		// concat(String msg) �޼���� ���ڿ� ����
		String temp = ssn.concat(" �ȳ��ϼ���");
		System.out.println(temp);

		// endsWith(Sting temp) �޼���� temp ���ڿ��� ������ true, �ƴϸ� false
		String fileName = "test.zip";
		if (fileName.endsWith("zip")) {
			System.out.println("�������� �Դϴ�.");
		} else if (fileName.endsWith("doc")) {
			System.out.println("Office �����Դϴ�");
		} else {
			System.out.println("���� �Դϴ�.");
		}

		// startsWith(Sting temp) �޼���� temp ���ڿ��� �����ϸ� true, �ƴϸ� false
		String url = "http://www.naver.com/";
		String uri = "sports/";
		System.out.println(url + uri);
		if (uri.startsWith("sports")) {
			System.out.println("������ �޴� �Դϴ�.");
		} else if (uri.startsWith("news")) {
			System.out.println("���� �޴� �Դϴ�.");
		} else {
			System.out.println("404 ������ �Դϴ�.");
		}

		String s1 = "Java";
		String s2 = "JAVA";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));

		s2 = s2.toLowerCase();
		System.out.println(s2);

		s1 = s1.toUpperCase();
		System.out.println(s1);

		ssn = ssn.replaceAll("-", "��");
		System.out.println(ssn);

		String html = "�ȳ��ϼ���\n���� �ڻ����Դϴ�.\n������ �� ��Ź�帳�ϴ�.";
		html = html.replaceAll("\n", "<br>");
		System.out.println(html);
		// 234567��8923456
		String ssn1 = ssn.substring(0, 6);
		String ssn2 = ssn.substring(7);

		System.out.println(ssn1);
		System.out.println(ssn2);

		fileName = "abc.cde.fgh.zip";
		String fileName1 = fileName.substring(0, fileName.lastIndexOf("."));
		String fileName2 = fileName.substring(fileName.lastIndexOf("."));

		System.out.println(fileName1);
		System.out.println(fileName2);

		fileName1 = " Hello";
		fileName2 = "Hello";
		if (fileName1.trim().equalsIgnoreCase(fileName2)) {
			System.out.println("����");
		} else {
			System.out.println("����");

		}

		int a = 10;

		String t1 = String.valueOf(a);
		String t2 = a + "";
		System.out.println(t1);
		System.out.println(t2);

		ssn = "234567-8923456";
		String[] t3 = ssn.split("-");
		for (int i = 0; i < t3.length; i++) {
			System.out.println(t3[i]);
		}

		String t4 = String.format("%,.2f and %,.2f", 1000.5454, 2000000.3232);
		System.out.println(t4);

		String str = String.format("%1$,10.10f, %2$,10.2f, %3$,10.3f", 1111.11, 2222.22, 3333.33);
		System.out.println(str);

		int b1 = 10;
		int b2 = 20;
		System.out.printf("b1�� ���� %d�̰�,\nb2�� ���� %d �Դϴ�.", b1, b2);

	}
}
