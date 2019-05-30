package java_20190530;

public class Customer {

	String name;
	String cphone;
	static double interestRate;
	static final String BANKNAME = "신한은행";

	public void register() {
		System.out.println("고객이 등록 되었습니다.");
		System.out.println("이름 : " + name + ", 핸드폰 번호 : " + cphone + ", 이자율 : " + interestRate + ", 은행명 : " + BANKNAME + "\n");
	}

}
