package AssignmentException;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        try {
            System.out.println(arr[9]); // 10th element (index 9)
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: " + e);
        }
    }
}
