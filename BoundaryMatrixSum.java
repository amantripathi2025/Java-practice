import java.util.Scanner;
public class BoundaryMatrixSum {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = input.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.println("The matrix is: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 || j == 0 || i == rows - 1 || j == cols - 1){
                    sum += matrix[i][j];
                }
            }
        }

        System.out.println("Sum of boundary elements: " + sum);
    }
}
