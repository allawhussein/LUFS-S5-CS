package hierarchy_management;

import java.util.ArrayList;
import java.util.Arrays;

public class ComputerScienceTeacher extends Teacher {
	public static final ArrayList<String> csCourses = 
			new ArrayList<String>(Arrays.asList("OOP", "DS", "SE", "DB"));
	
	private String assignedCourse;
	
	public String getAssignedCourse() {
		return assignedCourse;
	}
	public void setAssignedCourse(String assignedCourse) {
		this.assignedCourse = assignedCourse;
	}

}
