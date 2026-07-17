import java.util.*;

public class ConvertIt {
    public static List<Integer> modifyArray(int n, List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        int maxSoFar = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            // Update maximum encountered so far
            maxSoFar = Math.max(maxSoFar, arr.get(i));
            // Add the maximum to current element
            result.add(arr.get(i) + maxSoFar);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        
        List<Integer> result = modifyArray(n, arr);
        
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        
        scanner.close();
    }
}