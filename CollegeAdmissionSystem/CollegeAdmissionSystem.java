import java.sql.*;
import java.util.Scanner;

public class CollegeAdmissionSystem {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== College Admission System ====");
            System.out.println("1. Register Student");
            System.out.println("2. Add Course");
            System.out.println("3. Apply for Course");
            System.out.println("4. Process Merit List");
            System.out.println("5. View Applications");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> addCourse();
                case 3 -> applyForCourse();
                case 4 -> processMeritList();
                case 5 -> viewApplications();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void registerStudent() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter DOB (YYYY-MM-DD): ");
            String dob = sc.nextLine();
            System.out.print("Enter marks: ");
            float marks = sc.nextFloat();
            sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            String sql = "INSERT INTO students(name, dob, marks, email, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, Date.valueOf(dob)); 
            ps.setFloat(3, marks);
            ps.setString(4, email);
            ps.setString(5, phone);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student registered." : "Error in registration.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addCourse() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter course name: ");
            String name = sc.nextLine();
            System.out.print("Enter cut-off marks: ");
            float cutoff = sc.nextFloat();
            sc.nextLine();

            String sql = "INSERT INTO courses(course_name, cut_off) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, cutoff);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Course added." : "Failed to add course.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void applyForCourse() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter student ID: ");
            int studentId = sc.nextInt();
            System.out.print("Enter course ID: ");
            int courseId = sc.nextInt();
            sc.nextLine();

            String sql = "INSERT INTO applications(student_id, course_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Application submitted." : "Failed to apply.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void processMeritList() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT a.application_id, s.marks, c.cut_off FROM applications a " +
                    "JOIN students s ON a.student_id = s.student_id " +
                    "JOIN courses c ON a.course_id = c.course_id WHERE a.status = 'PENDING'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int appId = rs.getInt("application_id");
                float marks = rs.getFloat("marks");
                float cutoff = rs.getFloat("cut_off");

                String status = (marks >= cutoff) ? "APPROVED" : "REJECTED";
                PreparedStatement ps = conn.prepareStatement("UPDATE applications SET status = ? WHERE application_id = ?");
                ps.setString(1, status);
                ps.setInt(2, appId);
                ps.executeUpdate();
            }

            System.out.println("Merit list processed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void viewApplications() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT a.application_id, s.name, c.course_name, a.status FROM applications a " +
                    "JOIN students s ON a.student_id = s.student_id " +
                    "JOIN courses c ON a.course_id = c.course_id";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nApplication ID | Student Name | Course | Status");
            while (rs.next()) {
                System.out.printf("%14d | %-12s | %-10s | %s\n",
                        rs.getInt("application_id"),
                        rs.getString("name"),
                        rs.getString("course_name"),
                        rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

