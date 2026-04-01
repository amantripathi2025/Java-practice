package AssignmentException;

public class Q4 {
    static void checkNegative(int num) throws Exception {
        if (num < 0) {
            throw new Exception("Negative number not allowed: " + num);
        }
        System.out.println("Number is valid: " + num);
    }

    public static void main(String[] args) {
        try {
            checkNegative(10);
            checkNegative(-5);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}