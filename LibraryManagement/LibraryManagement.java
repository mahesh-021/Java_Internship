import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Status: " + (isIssued ? "Issued" : "Available");
    }
}

class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}


class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    void issueBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option (1-5): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    library.addBook(new Book(id, title));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1 to 5.");
            }
        }

        sc.close();
    }
}
