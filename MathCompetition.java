import java.util.*;

public class MathCompetition {

    public static long minimumTime(int N, long K, long[] A) {
        // If N is 0 or K is 0
        if (N == 0 || K == 0) {
            return 0;
        }
        
        // Check if impossible: if all A[i] == 0 and K > 0
        boolean hasNonZero = false;
        for (int i = 0; i < N; i++) {
            if (A[i] > 0) {
                hasNonZero = true;
                break;
            }
        }
        if (!hasNonZero) {
            return -1; // Impossible to solve any problem
        }
        
        // Find maximum possible time: max(A) * K (worst case single person solves all)
        long maxTime = Long.MAX_VALUE / 2;
        // More practical bound: max(A) * K
        long maxA = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > maxA) {
                maxA = A[i];
            }
        }
        // Upper bound: maxA * K (if K is large, this could overflow, so cap it)
        long high = maxA * K;
        if (high < 0) { // overflow check
            high = Long.MAX_VALUE;
        }
        
        long low = 0;
        long answer = -1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canSolve(N, K, A, mid)) {
                answer = mid;
                high = mid - 1; // Try to find smaller time
            } else {
                low = mid + 1;
            }
        }
        
        return answer;
    }
    
    private static boolean canSolve(int N, long K, long[] A, long time) {
        if (time == 0) {
            return K == 0;
        }
        
        long totalSolved = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > 0) {
                totalSolved += time / A[i];
                if (totalSolved >= K) {
                    return true; // Early exit to avoid overflow
                }
            }
        }
        return totalSolved >= K;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextLong();
        long[] A = new long[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        
        long result = minimumTime(N, K, A);
        System.out.println(result);
        
        sc.close();
    }
}