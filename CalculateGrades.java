import java.util.Scanner;
public class CalculateGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to calculate the grade");

        System.out.println("Enter the total marks: ");
        float totalmarks = input.nextFloat();

        System.out.println("Enter the obtained marks: ");
        float obtainedmarks = input.nextFloat();

        float Percentage =  (obtainedmarks * 100) / totalmarks;
        System.out.println("The percentage of the student is: " +Percentage+ "%");
        if(Percentage >= 90){
            System.out.println("Grade A");
        }

        else if(Percentage >= 80){
               System.out.println("Grade B");
        }

        else if(Percentage >= 60){
            System.out.println(("Grade c"));
        }

        else if(Percentage >= 35){
            System.out.println("Grade D");
        }

        else{
            System.out.println("Fail");
        }

        input.close();
    }
}
