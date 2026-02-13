import java.util.Scanner;

public class MatrixAddition {

    public static void main(String[] args) {

        if (args.length < 1) {

            System.out.println("Please provide the matrix order N as a command line argument.");

            return;

        }

        int N = Integer.parseInt(args[0]);

        int[][] A = new int[N][N];

        int[][] B = new int[N][N];

        int[][] C = new int[N][N];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of first matrix:");

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                A[i][j] = sc.nextInt();

            }

        }

        System.out.println("Enter elements of second matrix:");

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                B[i][j] = sc.nextInt();

            }

        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                C[i][j] = A[i][j] + B[i][j];

            }

        }

        System.out.println("Resultant Matrix after Addition:");

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                System.out.print(C[i][j] + " ");

            }

            System.out.println();

        }

        sc.close();

    }

}