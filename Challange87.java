package exception;

import java.util.Scanner;

public class Challange87 {
    public static class Calculator {
        static void main() {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the Calculator");

            System.out.println("Enter your first number: ");
            int first = input.nextInt();

            System.out.println("Enter your second number: ");
            int second = input.nextInt();

            try{
                int result = first/second;
                System.out.println("Result is: "+result);
            }catch(ArithmeticException ex){
                if(ex.getMessage().equals("/ by zero")){
                    System.out.println("Divide by zero occured");
                }
                else{
                    throw ex;
                }
            }
        }
    }
}
