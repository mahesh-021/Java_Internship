public class Student {
    public int id;
    public String name;
    public int[] marks;
    public double average;
    public char grade;

    public Student(int id, String name, int[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        calculateAverageAndGrade();
    }

    public void calculateAverageAndGrade() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        this.average = sum / (double) marks.length;

        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else grade = 'F';
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.print("Marks: ");
        for (int mark : marks) System.out.print(mark + " ");
        System.out.printf("\nAverage: %.2f, Grade: %c\n", average, grade);
        System.out.println("-----------------------------------");
    }
}
