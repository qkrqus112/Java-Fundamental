package java_20190531;

import java_20190531.tt.Cat;

public class AccessModifierDemo extends Cat {
	public static void main(String[] args) {

		Car c = new Car();
		// private�� ���� Ŭ���������� ������ ����
		// c.modelNumber = "68��4472";

		// default�� ���� ��Ű��(���丮)���� ���ٰ���
		c.color = "red";

		// ���� �ٸ� ��Ű������ ��ӹ��� ��� ���ٰ���
		c.doorCount = 5;

		// ���� �ٸ� ��Ű������ ���� ����
		c.price = 10_000_000;

		System.out.println(c.color);
		System.out.println(c.doorCount);
		System.out.println(c.price);

		Cat cat = new Cat();
		cat.nickName = "tomcat";

		System.out.println(cat.nickName);

		AccessModifierDemo a = new AccessModifierDemo();
		//Cat Ŭ������ ��ӹ����� protected�� ���ٰ���
		a.age = 10;
		a.nickName = "����";

	}
}
