package AssignmentException;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int num = Integer.parseInt(sc.nextLine());
            System.out.println("You entered: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Exception type: NumberFormatException");
            System.out.println("Message: " + e.getMessage());
        }
    }
}