package school_mvc;

public class Person {
    private String lName;
    private String fName;
    private int age;

    public String getlName() {
        return lName;
    }
    public String getfName() {
        return fName;
    }
    public int getAge() {
        return age;
    }
    void happyBirthday() {
        age++;
    }
    @Override
    public String toString() {
        return fName + lName + ": " + String.valueOf(age);
    }
    public Person(String lName, String fName, int age) {
        this.lName = lName;
        this.fName = fName;
        this.age = age;
    }
}
