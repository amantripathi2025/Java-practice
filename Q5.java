package AssignmentException;

public class Q5 {
    public static void main(String[] args) {
        int[] result = new int[1];
        try {
            int a = 20, b = 0;
            result[0] = a / b;         // ArithmeticException if b = 0
            System.out.println("Result stored: " + result[0]);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
            result[0] = -1;            // Store fallback value
        } finally {
            System.out.println("Finally block executed.");
            System.out.println("Element in array: " + result[0]);
        }
    }
}