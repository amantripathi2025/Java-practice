package Exception;

import java.util.Scanner;

class DivisionByZeroException extends Exception{
    public DivisionByZeroException(String Message){
        super(Message);
    }
}
public class Exception1 {
    static int divide(int a, int b) throws DivisionByZeroException{
      if(b==0){
          throw new DivisionByZeroException("Cannot divide by zero");
      }
      return a/b;
    }

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Enter first number: ");
       int num1 = input.nextInt();
       System.out.println("Enter second number: ");
       int num2 = input.nextInt();

       try{
           int result= divide(num1 , num2);
           System.out.println("Result: "+result);

       } catch(DivisionByZeroException e){
           System.out.println("Exception Occured: " +e.getMessage());
           System.out.println("Please enter a positive integer");
       }

       finally {
           System.out.println("Finally block executed");
       }
    }
}
