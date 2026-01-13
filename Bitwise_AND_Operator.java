import java.util.Scanner;
public class Bitwise_AND_Operator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Showcasing Bitwise AND Operater");

        System.out.println("Please enter the first number: ");
        int first = input.nextInt();

        System.out.println("Enter the second number: ");
        int second = input.nextInt();

        int result = first & second;
        System.out.println("Result is: "+result);
        
        input.close();
    }
}
