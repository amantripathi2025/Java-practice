import java.util.Scanner;
public class Bitwise_Compliment {
     public static void main(String[] args) {
             Scanner input = new Scanner(System.in);
             System.out.println("Welcome to Bitwise Compliment operator");

             System.out.println("Enter the first number: ");
             int first = input.nextInt();

             int result = ~first;
             System.out.println("Result is : "+result);
            
             input.close();
     }    
}
