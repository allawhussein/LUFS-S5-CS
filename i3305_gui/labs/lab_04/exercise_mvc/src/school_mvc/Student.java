package school_mvc;

public class Student extends Person{
    private int studentID;
    private int gradeLevel;

    public int getStudentID() {
        return studentID;
    }
    public int getGradeLevel() {
        return gradeLevel;
    }
    @Override
    public void happyBirthday() {
        super.happyBirthday();
        gradeLevel++;
    }
    @Override
    public String toString(){
        return super.toString() + " (" + String.valueOf(studentID) + " - " + String.valueOf(gradeLevel) + ")";
    }
    public Student(String lName, String fName, int age, int studentID, int gradeLevel) {
        super(lName, fName, age);
        this.studentID = studentID;
        this.gradeLevel = gradeLevel;
    }
}
