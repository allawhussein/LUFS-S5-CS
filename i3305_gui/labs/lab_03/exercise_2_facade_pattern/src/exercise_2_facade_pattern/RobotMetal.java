package exercise_2_facade_pattern;

public class RobotMetal {
	private String metal;
	public void SetMetal(String metal)
	{
		this.metal=metal;
		System.out.println("Metal is set to : "+this.metal);
	} 
}
