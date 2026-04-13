package Thread;

public class MyThread {
    static void main() {
        Thread t = Thread.currentThread();
        System.out.println(t);
        t.setName("MyThread");
        t.setPriority(9);
        t.getId();
        System.out.println(t);
        System.out.println(t.getName());
    }
}
