package hierarchy_management;

import java.util.ArrayList;
import java.util.Arrays;

public class MathTeacher extends Teacher {
	public static final ArrayList<String> mathCourses = new ArrayList<String>(Arrays.asList("Algebra", "Analysis", "Statistics", "Differential Geometry"));
	private String assignedCourse;
	
	public String getAssignedCourse() {
		return assignedCourse;
	}
	public void setAssignedCourse(String assignedCourse) {
		this.assignedCourse = assignedCourse;
	}
}
