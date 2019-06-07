package java_20190607;

import java.util.ArrayList;

public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new <String>ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		// list.add(10);

		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			System.out.println(temp);
		}
		for(String value : list){
			System.out.println(value);
		}
	}
}
