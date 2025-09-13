import java.util.ArrayList;
import java.util.Scanner;

// Student class with ID, name, and marks
class Student {
    int id;
    String name;
    float marks;

    Student(int id, String name, float marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    float marks = sc.nextFloat();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added.");
                    break;

                case 2:
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.id == updateId) {
                            sc.nextLine(); // consume newline
                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter new marks: ");
                            s.marks = sc.nextFloat();
                            System.out.println("Student updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    Student toDelete = null;
                    for (Student s : students) {
                        if (s.id == deleteId) {
                            toDelete = s;
                            break;
                        }
                    }
                    if (toDelete != null) {
                        students.remove(toDelete);
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
