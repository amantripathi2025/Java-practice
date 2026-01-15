import java.util.Scanner;
public class LEft_Shift_Operator {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number: ");
            int num = input.nextInt();

            int result = num << 1;
            System.out.println("Result is : "+ result);

            input.close();
        }    
}
