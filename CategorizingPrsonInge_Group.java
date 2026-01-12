import java.util.Scanner;
public class CategorizingPrsonInge_Group {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to know your Age Group");

        System.out.println("Enter your Age: ");
        int age = input.nextInt();

        if(age < 13){
            System.out.println("Beta! You are a child");
        }

        else if(age <= 20){
            System.out.println("You are a teenager");
        }

        else if(age <= 50){
            System.out.println("You are an adult");
        }

        else{
            System.out.println("You are a senior citizen");
        }

        input.close();
    }
}
