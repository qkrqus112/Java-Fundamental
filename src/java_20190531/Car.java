package java_20190531;

public class Car {
	private String modelNumber;
	String color;
	protected int doorCount;
	public double price;

	// art + shift + s => c
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	// art + shift + s => o
	public Car(String modelNumber, String color, int doorCount, double price) {
		super();
		this.modelNumber = modelNumber;
		this.color = color;
		this.doorCount = doorCount;
		this.price = price;
	}

}
