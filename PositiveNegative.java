import java.util.Scanner;
public class PositiveNegative {
   public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the Value identifier of the numbers");
    System.out.println("Enter the number: ");
    float num = input.nextFloat();

    if(num > 0){
        System.out.println("It is a positive number");
    }

    else if(num < 0 ){
        System.out.println("It is a negative number: ");
    }

    else{
        System.out.println("It is zero");
    }

    input.close();
   } 
}
