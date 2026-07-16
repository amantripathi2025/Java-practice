import java.io.*;
import java.util.*;

class RepeatingBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int totalBoxes = sc.nextInt();
        int n = totalBoxes / 2;
        
        // Approach: Since one number appears n times and all others appear once
        // If we XOR all numbers, repeated number will appear n times (n XORed together)
        // n could be even or odd, so this approach needs careful handling
        // Better to use HashMap for clarity
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < totalBoxes; i++) {
            int label = sc.nextInt();
            map.put(label, map.getOrDefault(label, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            if (map.get(key) == n) {
                System.out.println(key);
                break;
            }
        }
        
        sc.close();
    }
}