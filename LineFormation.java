 import java.util.*;

class Node {
    int val;
    Node next;
    Node(int x) { val = x; next = null; }
}

public class LineFormation {
    public static int minChanges(Node head, int n) {
        // Extract values from linked list
        int[] original = new int[n];
        Node current = head;
        int index = 0;
        while (current != null && index < n) {
            original[index] = current.val;
            current = current.next;
            index++;
        }
        
        // Create a copy and sort it
        int[] sorted = original.clone();
        Arrays.sort(sorted);
        
        // Count positions where values differ
        int changes = 0;
        for (int i = 0; i < n; i++) {
            if (original[i] != sorted[i]) {
                changes++;
            }
        }
        
        return changes;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Node head = null;
        Node tail = null;
        
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        
        System.out.println(minChanges(head, n));
        sc.close();
    }
} 