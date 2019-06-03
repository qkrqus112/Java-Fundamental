package java_20190603;


public class ExtendsDemo {
	public static void main(String[] args) {

		Customer c = new Customer();
		c.name = "박상준";
		c.cphone = "010-2071-1984";
		System.out.println("이름 : " + c.name);
		System.out.println("핸드폰 : " + c.cphone);
		c.actionCustomer();

		Alba a = new Alba();
		a.name = "알바생";
		a.cphone = "010-3439-9633";
		a.address = "서울";
		System.out.println("이름 : " + a.name);
		System.out.println("핸드폰 : " + a.cphone);
		System.out.println("주소 : " + a.address);
		a.actionAlba();
		a.actionCustomer();
		

		Manager m = new Manager();
		m.name = "매니저";
		m.cphone = "010-2545-1845";
		m.address = "경기도";
		m.id = "qkrqus119";
		m.password = "123123";
		System.out.println("이름 : " + m.name);
		System.out.println("핸드폰 : " + m.cphone);
		System.out.println("주소 : " + m.address);
		System.out.println("아이디 : " + m.id);
		System.out.println("비밀번호 : " + m.password);
		m.actionCustomer();
		m.actionManager();

		// Super 타입(Alba)으로 Sub 객체(Manager)를 생성할 수 있다.
		// 멤버변수는 Super 타입(Alba)을 포함한 상위 클래스(Customer) 접근 가능.
		Alba alba = (Alba)new Manager();
		alba.name = "매니저";
		alba.cphone = "010-2545-1845";
		alba.address = "경기도";
		// a.id = "qkrqus119";
		// a.password = "123123";
		System.out.println("이름 : " + m.name);
		System.out.println("핸드폰 : " + m.cphone);
		System.out.println("주소 : " + m.address);
		alba.actionAlba();
		alba.actionCustomer();

		
		
		
		
	}
}
