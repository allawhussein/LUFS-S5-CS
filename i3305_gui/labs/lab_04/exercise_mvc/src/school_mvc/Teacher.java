package school_mvc;

public class Teacher extends Person{
    private String classroom;
    private int salary;

    public String getClassroom() {
        return classroom;
    }
    public int getSalary() {
        return salary;
    }
    @Override
    public void happyBirthday(){
        super.happyBirthday();
        salary += 1000;
    }
    @Override
    public String toString(){
        return super.toString() + " (" + classroom + " - $" + String.valueOf(salary) + ")";
    }
    public Teacher(String lName, String fName, int age, String classroom, int salary) {
        super(lName, fName, age);
        this.classroom = classroom;
        this.salary = salary;
    }
}