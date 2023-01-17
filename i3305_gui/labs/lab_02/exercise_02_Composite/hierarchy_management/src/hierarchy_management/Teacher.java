package hierarchy_management;

public class Teacher {
	protected String name;
	protected String phoneNumber;
	protected String educationLevel;
	protected float salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	@Override
	public String toString() {
		return "Teacher " + name + " of educational level: " + educationLevel + " contact: " + phoneNumber;
	}
}
