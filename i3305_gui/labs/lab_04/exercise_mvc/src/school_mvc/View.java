package school_mvc;

import java.util.Scanner;

public class View {
    String showMenu(){
        System.out.println("Please enter one of the following options:j\n" +
                "\tadd teacher\n" +
                "\tadd student\n" +
                "\tlist people\n" +
                "\texit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    String addStudent(){
        System.out.println("Please enter the following items for the new student, all on the same line\n" +
                "lastName firstName age studentID gradeLevel");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    String addTeacher(){
        System.out.println("Please enter the following items for the new teacher, all on the same line\n" +
                "lastName firstName age classroom salary");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    void listPeople(Person person[]){
        System.out.println("The school contains the following people:");
        for (int i = 0; i < person.length; i++){
            System.out.println(String.valueOf(i) + ") " + person[i].toString());
        }
    }
    void showError(String error){
        System.out.println("Error: " + error);
    }
}
