package example.com;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ArrayUserInput {
    public static void main(String[]args){
        int x[] = new int[4];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the 4 elements: ");

        for(int i = 0; i < x.length; i++){
            x[i] = input.nextInt();
        }
        for(int i = 0; i<x.length; i++){
            System.out.println(x[i]);
        }
        System.out.println("Display Array elements in ascending order");
        int temp = 0;
        for(int i = 0; i<x.length; i++){
            for(int j = 0; j<=i;j++){
                if(x[i] < x[j]){
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
        for(int i = 0; i<x.length ; i++){
            System.out.println(x[i]);
        }
    }
}
