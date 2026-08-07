import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int user_logic(int n, String s) {
        // Map to track available pieces (lowercase letters)
        Map<Character, Integer> availablePieces = new HashMap<>();
        int extraPiecesNeeded = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isUpperCase(c)) {
                // This is a puzzle (lock)
                char puzzleType = Character.toLowerCase(c);
                
                // Check if we have a matching piece
                if (availablePieces.containsKey(puzzleType) && availablePieces.get(puzzleType) > 0) {
                    // Use one piece
                    availablePieces.put(puzzleType, availablePieces.get(puzzleType) - 1);
                } else {
                    // Need to buy a piece
                    extraPiecesNeeded++;
                }
            } else {
                // This is a piece (key)
                availablePieces.put(c, availablePieces.getOrDefault(c, 0) + 1);
            }
        }
        
        return extraPiecesNeeded;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String s = scanner.nextLine();
        
        System.out.println(user_logic(n, s));
        scanner.close();
    }
}