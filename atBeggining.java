package LinkedList;

class Node1 {
    private String data;
    private Node next;

    public Node1(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }
}

class LinkedList {

    private Node head;
    private Node tail;

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void addAtEnd(String data) {
        Node node = new Node(data);
        if (this.head == null)
            this.head = this.tail = node;
        else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void addAtBeginning(String data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
    }

    // Fixed: insert now actually inserts "data" after the node containing "dataBefore"
    public void insert(String data, String dataBefore) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            // Find the node after which new node should be inserted
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().equals(dataBefore)) {
                    // Insert new node after temp
                    node.setNext(temp.getNext());
                    temp.setNext(node);
                    // If temp was the tail, update tail to new node
                    if (temp == this.tail)
                        this.tail = node;
                    return;
                }
                temp = temp.getNext();
            }
            System.out.println("Node '" + dataBefore + "' not found.");
        }
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}

class Tester {

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.addAtEnd("Milan");
        list.addAtEnd("Venice");
        list.addAtEnd("Munich");
        list.addAtBeginning("Nice");
        list.insert("Prague", "Munich");

        Node current = list.getHead();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}