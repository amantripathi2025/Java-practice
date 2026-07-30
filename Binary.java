import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            // Array to store the number of unique BSTs for each number of nodes
            long[] dp = new long[n + 1];
            
            // Base cases
            dp[0] = 1;
            if (n >= 1) {
                dp[1] = 1;
            }
            
            // Calculate DP using Catalan number formula
            // dp[i] = sum(dp[j-1] * dp[i-j]) for j from 1 to i
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            
            System.out.println(dp[n]);
        }
        scanner.close();
    }
}