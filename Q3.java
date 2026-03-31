package AssignmentException;

public class Q3 {
    public static void main(String[] args) {
        String[] values = {"123", "abc", "456"};
        for (String s : values) {
            try {
                int num = Integer.parseInt(s);
                System.out.println("Converted: " + num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format for: \"" + s + "\"");
            }
        }
    }
}