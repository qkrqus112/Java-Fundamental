package java_20190603;

import java.lang.*;

class A extends Object {
	String name;

	A() {

	}

	A(String name) {
		super();
		this.name = name;
	}
}

class B extends A {
	B() {
		super();
	}
}

public class SuperDemo extends Object {
	public SuperDemo() {
		super();
	}
}