import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        String fileName = "notes.txt"; 

        while (running) {
            System.out.println("\n=== Notes Manager ===");
            System.out.println("1. Write a Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();

                    
                    try (FileWriter writer = new FileWriter(fileName, true)) {
                        writer.write(note + "\n");
                        System.out.println("Note saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\nYour Notes:");
                    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println("- " + line);
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
