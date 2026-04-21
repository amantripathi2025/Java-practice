package ProgramsJavaCollege;

import java.util.Scanner;

class DivisionByZero extends Exception{
    DivisionByZero(String msg){
        super(msg);
    }
}
class Calculation{
    int a ,b, c;
    Scanner input = new Scanner(System.in);
    void getInputs(){
        System.out.print("Enter a number: ");
        a = input.nextInt();
        System.out.print("Enter b number: ");
        b = input.nextInt();
    }
    void divide(){
        System.out.println(a+" numerator "+b +" denominator");
        try {
            if (b == 0)
                throw new DivisionByZero("Invalid input\n" +
                        "Divide by zero is not allowed\n" +
                        "Please enter another number rather than zero\n" +
                        "Thank you!!");
            c = a / b;
            System.out.println(a + " / " + b + " = " + c  );
        } catch (DivisionByZero e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Demo of division by zero exception");
        }
    }
}
public class Q9 {
    public static void main(String[] args) {
        Calculation c = new Calculation();

        c.getInputs();
        c.divide();
    }
}
