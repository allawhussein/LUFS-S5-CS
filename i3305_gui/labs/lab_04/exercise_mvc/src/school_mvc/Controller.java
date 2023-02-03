package school_mvc;

public class Controller {
    private Person[] persons;
    private View view;

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }

    void Controller(){
        persons = new Person[20];
        view = new View();
    }

    public void run(){
        while (true){
            String menuEntry = view.showMenu();
            if (menuEntry.equalsIgnoreCase("add teacher")){
                String[] newTeacherOptions = view.addTeacher().split(" ");
            }
            else if (menuEntry.equalsIgnoreCase("add student")){
                String[] newStudentOptions = view.addStudent().split(" ");
            }
            else if (menuEntry.equalsIgnoreCase("list people")){

            }
            else if (menuEntry.equalsIgnoreCase("exit")){
                break;
            }
            else {
                System.out.println("Wrong choice, check you spelling!");
            }
        }
    }
    public void addStudent(String input){

    }
    public void addTeacher(String input){

    }
    public Person[] getPersons(){

    }
    public void setPerson(Person[] input){

    }
}
