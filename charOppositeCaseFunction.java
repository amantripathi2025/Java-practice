import java.util.Scanner;

public class charOppositeCaseFunction {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char ch = input.next().charAt(0);
        if(Character.isUpperCase(ch)){
            System.out.println("The opposite case of " + ch + " is: " + Character.toLowerCase(ch));
        } else if(Character.isLowerCase(ch)){
            System.out.println("The opposite case of " + ch + " is: " + Character.toUpperCase(ch));
        } else {
            System.out.println("Invalid input. Please enter an alphabetic character.");
        }
    }
}
