import java.util.Scanner;

public class SumAndAverageInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Welcome to Calculator");
        System.out.println("Please enter the number of elements: ");
        int size = input.nextInt();
        int[] nums = new int[size];
        int i = 0;
        while(i < size){
            System.out.println("Please enter element number " + (i+1) + ":");
            nums[i] = input.nextInt();
            i++;
        }
        long sum = sum(nums);
        int avg = average(nums);
        System.out.println("Sum of the number is: " +sum);
        System.out.println("Average of the number is: " +avg);
        input.close();
    }
    

    public static long sum(int[] numArray){
        long sum = 0;
        int i = 0;
        while(i < numArray.length){
            sum += numArray[i];
            i ++;
        }
        return sum;
    }

    public static int average(int[] numArray){
        long sum = sum(numArray); //can use double for the point values and no need to typecast after that below at the place of int 
        return (int) (sum / numArray.length);
    }
}
