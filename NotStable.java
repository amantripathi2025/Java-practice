import java.util.*;

public class NotStable {
    public static String[] userLogic(int n, int[] arr) {
        // Sort the array
        Arrays.sort(arr);
        
        // Try non-decreasing order (sorted ascending)
        int[] ascending = arr.clone();
        boolean ascValid = checkPrefixSum(ascending);
        
        // Try non-increasing order (sorted descending)
        int[] descending = new int[n];
        for (int i = 0; i < n; i++) {
            descending[i] = arr[n - 1 - i];
        }
        boolean descValid = checkPrefixSum(descending);
        
        // If neither works
        if (!ascValid && !descValid) {
            return new String[]{"IMPOSSIBLE"};
        }
        
        // If both work, choose the one with larger first element
        if (ascValid && descValid) {
            if (descending[0] > ascending[0]) {
                return formatResult(descending);
            } else {
                return formatResult(ascending);
            }
        }
        
        // Only one works
        if (ascValid) {
            return formatResult(ascending);
        } else {
            return formatResult(descending);
        }
    }
    
    private static boolean checkPrefixSum(int[] arr) {
        long sum = 0;
        for (int val : arr) {
            sum += val;
            if (sum == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static String[] formatResult(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return new String[]{sb.toString()};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        String[] result = userLogic(n, arr);
        System.out.println(result[0]);
        
        scanner.close();
    }
}