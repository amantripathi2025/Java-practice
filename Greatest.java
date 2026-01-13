import java.util.Scanner;
public class Greatest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int a = input.nextInt();

        System.out.println("Enter the second number: ");
        int b = input.nextInt();

        System.out.println("Enter the third numbe: ");
        int c = input.nextInt();

        if(a>b && a>c){
            System.out.println(a + " is the greatest number");
        }

        else if( b>a && b>c){
            System.out.println(b + " is the greatest number");
        }

        else if(c>a && c>b){
            System.out.println(c + " is the greatest number");
        }

        else{
            System.out.println("All are the same number");
        }

        input.close();
    }
                            
}
