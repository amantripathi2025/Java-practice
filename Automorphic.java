import java.util.Scanner;
public class Automorphic {
    public static void main(String[]args){
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int num = sc.nextInt();
    
    int square = num * num;
    int temp = num;
    int digits = 0;

    System.out.println("Square of the number: " + square);

    while(temp > 0){
        digits++;
        temp = temp/10;
    }

    int k = (int)Math.pow(10, digits);
    if(square % k == num)
        System.out.println("Automorphic Number");
    else
        System.out.println("Not an Automorphic Number");
    
    }
}



