import java.util.Scanner;
public class Right_Shift {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enyter the number: ");
            int num = input.nextInt();
            
            int result = num >> 1;
            System.out.println("Result is : "+result);

            input.close();
        }    
}
