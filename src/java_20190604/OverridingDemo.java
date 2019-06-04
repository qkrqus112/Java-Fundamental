package java_20190604;

public class OverridingDemo {

	public static void main(String[] args) {
		// Shape shape = new Shape();


		Triangle t = new Triangle();
		t.draw();

		Rectangle r = new Rectangle();
		r.draw();

		Shape s = new Triangle();
		s.name = "삼각형";
		s.degree = 60;
		s.drawLine();
		s.draw();// Shape의 draw()가 호출되지 않고 Triangle의 draw()가 호출됨
		// s.dot = "";
		// s.angleDgree = "180";
		// s.drawCoordinate();
	}
}
