package exercise_2_facade_pattern;

public class RobotConstruct {
	RobotBody robotbody;
	RobotColor robotcolor;
	RobotMetal robotmetal;
	
	public void constructRobot(String color, String metal) {
		robotbody = new RobotBody();
		robotcolor = new RobotColor();
		robotmetal = new RobotMetal();
		
		robotbody.CreateBody();
		robotcolor.SetColor(color);
		robotmetal.SetMetal(metal);
		
		System.out.println("Robot Construction is Complete");
	}
}
