package LinkedList;

class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }
    public void setData(String data) { this.data = data; }
    public void setNext(Node node)   { this.next = node; }
    public String getData()          { return this.data; }
    public Node getNext()            { return this.next; }
}

class LinkedList1 {

    private Node head;
    private Node tail;

    public Node getHead() { return this.head; }
    public Node getTail() { return this.tail; }

    public void addAtEnd(String data) {
        Node node = new Node(data);
        if (this.head == null)
            this.head = this.tail = node;
        else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    // ✅ Added display method
    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}

class Add {
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1(); // ✅ Fixed class name
        list.addAtEnd("Milan");
        list.addAtEnd("Venice");
        list.addAtEnd("Munich");
        list.addAtEnd("Vienna");
        System.out.println("Adding an element to the linked list");
        list.display(); // ✅ Actually prints the nodes
    }
}