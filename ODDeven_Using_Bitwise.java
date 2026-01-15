import java.util.Scanner;
public class ODDeven_Using_Bitwise {
      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to determine the even or odd of a number by bitwise Operator");

        System.out.println("Enter the number: ");
        int num = input.nextInt();

        if((num & 1) == 1){
            System.out.println("Your number is odd");
        }

        else{
            System.out.println("Your number is even");
        }

        input.close();

      }    
}
