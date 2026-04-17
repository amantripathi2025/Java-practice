package Thread;

class NewThread1 implements Runnable {
    String name;
    Thread t;
    NewThread1(String name) {
        this.name=name;
        t = new Thread(this,name);
        System.out.println("NewThread1 "+t);
        t.start();
    }
    public void run() {
        try{
            for(int i = 5; i >0; i--){
                System.out.println(name+" : "+i);
                Thread.sleep(1000);
            }
        }  catch (InterruptedException e){
            System.out.println(name + " interrupted");
        }
        System.out.println(name+ " exiting");
    }
}


public class DemoJoin1 {
    static void main() {
        NewThread1 ob1 = new NewThread1("One");

        try{
            System.out.println("Waiting for threads to finish");
            ob1.t.join();
        } catch (InterruptedException e){
            System.out.println("Main Thread interrupted");
        }
    }
}
