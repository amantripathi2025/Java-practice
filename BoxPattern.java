import java.util.Scanner;

public class BoxPattern {
    public static String follows_ab_pattern(String s) {
        boolean seenB = false;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                seenB = true;
            } else if (c == 'a' && seenB) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(follows_ab_pattern(s));
        scanner.close();
    }
}