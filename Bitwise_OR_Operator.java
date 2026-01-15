import java.util.Scanner;
public class Bitwise_OR_Operator {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to bitwise operator OR");

            System.out.println("Enter the first number: ");
            int first = input.nextInt();

            System.out.println("Enter the second number: ");
            int second = input.nextInt();

            int result = first | second;
            System.out.println("Result is: "+result);

            input.close();
        }
}
