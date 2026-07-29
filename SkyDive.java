import java.util.*;

public class SkyDive {
    public static int minParachutes(int k, int n) {
        // DP table: dp[attempts][parachutes] = max floors that can be checked
        int[][] dp = new int[n + 1][k + 1];
        
        for (int attempts = 1; attempts <= n; attempts++) {
            for (int parachutes = 1; parachutes <= k; parachutes++) {
                dp[attempts][parachutes] = dp[attempts - 1][parachutes - 1] + 
                                           dp[attempts - 1][parachutes] + 1;
            }
            if (dp[attempts][k] >= n) {
                return attempts;
            }
        }
        return n; // Should never reach here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // floors
        int k = scanner.nextInt(); // parachutes
        System.out.println(minParachutes(k, n));
        scanner.close();
    }
}