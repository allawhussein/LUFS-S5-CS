package exercise_2_facade_pattern;

public class RobotColor {
	private String color;
	public void SetColor(String color)
	{
		this.color = color;
		System.out.println("Color is set to : "+ this.color);
	}
}
