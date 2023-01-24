package adapter_pattern;

public class CalculatorAdapter {
	Rectangle rectangle;
	Calculator calc;
	
	public double getArea(Triangle triangle) {
		calc = new Calculator();
		rectangle = new Rectangle();
		rectangle.l = triangle.h;
		rectangle.w = triangle.b;
		return calc.getArea(rectangle) / 2;
	}
}
