package adapter_pattern;

public class Calculator {
	Rectangle rectangle;
	public double getArea(Rectangle r)
	{
		rectangle=r;
		return rectangle.l * rectangle.w;
	}
}
