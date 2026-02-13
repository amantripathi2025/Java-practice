import java.util.Scanner;

class Stack {

    int[] stack;

    int top;

    int maxSize = 10;

    Stack() {

        stack = new int[maxSize];

        top = -1;

    }

    void push(int value) {

        if (top == maxSize - 1) {

            System.out.println("Stack Overflow! Cannot push element.");

        } else {

            stack[++top] = value;

            System.out.println("Pushed: " + value);

        }

    }

    void pop() {

        if (top == -1) {

            System.out.println("Stack Underflow! Cannot pop element.");

        } else {

            System.out.println("Popped: " + stack[top--]);

        }

    }

    void display() {

        if (top == -1) {

            System.out.println("Stack is empty.");

        } else {

            System.out.print("Stack elements: ");

            for (int i = top; i >= 0; i--) {

                System.out.print(stack[i] + " ");

            }

            System.out.println();

        }

    }

}

public class StackDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack s = new Stack();

        int choice, value;

        do {

            System.out.println("\n1. Push");

            System.out.println("2. Pop");

            System.out.println("3. Display");

            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter value to push: ");

                    value = sc.nextInt();

                    s.push(value);

                    break;

                case 2:

                    s.pop();

                    break;

                case 3:

                    s.display();

                    break;

                case 4:

                    System.out.println("Exiting program.");

                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        sc.close();

    }

}