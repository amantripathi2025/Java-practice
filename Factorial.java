import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to factorial calculator");
        System.out.println("Please enter the number: ");
        int num = input.nextInt();
        long fact = factorial(num);
        System.out.println("Factorial is: " +fact);
        input.close();
    }
    public static long factorial(int num){
        if(num < 2){
            return 1;
        }    
        long fact = 1;
        int i = 2;
        while( i <= num){
            fact *= i;
            i++;
        }
        return fact;
    }
}
