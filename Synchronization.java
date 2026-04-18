package Thread;
class Callme{
    void call(String msg){
        System.out.println("[" +msg);
        try{
            Thread.sleep(500);
        } catch(InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;
    public Caller(Callme target, String msg){
        this.target = target;
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        synchronized (target){
            target.call(msg);
        }
    }
}

public class Synchronization {
    static void main() {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "World");
        Caller ob3 = new Caller(target, "Java");

    }
}
