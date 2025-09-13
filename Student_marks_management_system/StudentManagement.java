import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagement {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("---- Student Marks Management ----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Display Top Performer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAllStudents(); break;
                case 3: displayTopper(); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    public static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        int[] marks = new int[3];
        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }
        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!\n");
    }

    public static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.\n");
            return;
        }
        for (Student s : studentList) {
            s.display();
        }
    }

    public static void displayTopper() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.\n");
            return;
        }
        Student topStudent = studentList.get(0);
        for (Student s : studentList) {
            if (s.average > topStudent.average) {
                topStudent = s;
            }
        }
        System.out.println("---- Top Performer ----");
        topStudent.display();
    }
}
