package example.com;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = 3, subjects = 3;
        int[][] marks = new int[students][subjects];

        System.out.println("Enter marks:");
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                marks[i][j] = sc.nextInt();
            }
        }

        System.out.println("Marks are:");
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }
    }
}


