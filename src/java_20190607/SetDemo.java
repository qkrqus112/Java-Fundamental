package java_20190607;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		// �ڵ� import : Ctrl + Shift + o
		// �������� �ߺ��� ������� �ʰ�, ���� ����.
		// HashSet<String> set1 = new HashSet<String>();

		// TreeSet�� �������� �ߺ��� ������� �ʰ�, natural ordering(�������� ����)
		// TreeSet<String> set1 = new TreeSet<String>();

		// LinkedHashSet�� �������� �ߺ��� ������� �ʰ�, �Է��� ������� ���
		LinkedHashSet<String> set1 = new LinkedHashSet<String>();

		for (int i = 0; i < 20; i++) {
			// valueOf(int i) �޼ҵ�� int i�� ���ڿ��� ��ȯ
			set1.add(String.valueOf(i));
		}

		// HashSet ũ��
		System.out.println(set1.size());

		// ������ ���
		Iterator<String> iterator = set1.iterator();
		while (iterator.hasNext()) {
			String temp = iterator.next();
			System.out.println(temp);

		}

		Customer c1 = new Customer("ȫ�浿", 10);
		Customer c2 = new Customer("ȫ�浿", 10);
		Customer c3 = new Customer("ȫ�浿", 10);
		Customer c4 = new Customer("ȫ�浿", 10);

		HashSet<Customer> set2 = new HashSet<Customer>();
		set2.add(c1);
		set2.add(c2);
		set2.add(c3);
		set2.add(c4);

		System.out.println(set2.size());

		// ��� �����
		// set1.clear();

		TreeSet<Integer> set3 = new TreeSet<Integer>();

		while (true) {
			int random = (int) (Math.random() * 45) + 1;
			set3.add(random);
			if (set3.size() == 6)
				break;
		}

		Iterator<Integer> i = set3.iterator();
		while (i.hasNext()) {
			Integer temp = i.next();
			System.out.print(temp + "\t");
		}
	}

}

class Customer {
	private String name;
	private int age;

	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
