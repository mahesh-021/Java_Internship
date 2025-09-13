import java.util.Scanner;
public class Simple_Calculator {

    public static int add(int a, int b) {
        return a+b;
    }

    public static int subtract(int a, int b) {
        return a-b;
    }

    public static int multiply(int a, int b) {
        return a*b;
    }

    public static double division(int a, int b) {
        if(b==0) {
            System.out.println("Error: Can't be devided by Zero");
            return Double.NaN;
        }
    return (double) a/b;
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("\n--- Simple Calculator ---");
            System.out.println("1 --> Add, 2--> Subtract, 3--> Multiply, 4--> division, 5--.Exit");
            System.out.println("Choose an operation from 1 to 5");

            int choice = Sc.nextInt();

            if(choice>=1 && choice<=4) {
                System.out.println("Enter First number");
                int a = Sc.nextInt();
                System.out.println("Enter second number");
                int b = Sc.nextInt();

                switch(choice) {
                    case 1:
                         System.out.println("Result: " + add(a, b));
                         break;
                    case 2:
                        System.out.println("Result: " + subtract(a, b));
                        break;
                    case 3:
                        System.out.println("Result: " + multiply(a, b));
                        break;
                    case 4:
                        System.out.println("Result: " + division(a, b));
                        break;     
            }
        }
        else if(choice == 5) {
            System.out.println("Exiting");
            running = false;
        }
        else {
            System.out.println("Invlaid Choice please select between 1 to 5");
        }
        }
        Sc.close();
    }
}