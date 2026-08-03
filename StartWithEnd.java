import java.util.*;

class Node {
    int val;
    Node next;
    Node(int x) { val = x; next = null; }
}

public class StartWithEnd {
    public static Node buildLinkedList(int size, int[] elements) {
        if (size == 0) return null;
        Node head = new Node(elements[0]);
        Node current = head;
        for (int i = 1; i < size; i++) {
            current.next = new Node(elements[i]);
            current = current.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        Node head = buildLinkedList(N, arr);
        
        // Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Now compare first half with reversed second half
        Node first = head;
        Node second = prev;
        int maxSum = Integer.MIN_VALUE;
        
        while (second != null) {
            int sum = first.val + second.val;
            if (sum > maxSum) {
                maxSum = sum;
            }
            first = first.next;
            second = second.next;
        }
        
        System.out.println(maxSum);
        sc.close();
    }
}