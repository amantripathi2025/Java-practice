import java.util.*;

class Field {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.next());
        }
        String pattern = scanner.next();
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matchesPattern(word, pattern)) {
                result.add(word);
            }
        }
        
        System.out.println(result.size());
        if (result.size() > 0) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    private static boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        
        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if (wordToPattern.containsKey(w)) {
                if (wordToPattern.get(w) != p) {
                    return false;
                }
            } else {
                wordToPattern.put(w, p);
            }
            
            if (patternToWord.containsKey(p)) {
                if (patternToWord.get(p) != w) {
                    return false;
                }
            } else {
                patternToWord.put(p, w);
            }
        }
        
        return true;
    }
}