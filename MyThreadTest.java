package Thread;
class MyThreadTest1 implements Runnable {
    String str;

    public MyThreadTest1(String str) {
        this.str = str;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(str + " : " + i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
    public class MyThreadTest{
        static void main() {

             MyThreadTest1 ob1=new MyThreadTest1("MyThreadTest1");
             MyThreadTest1 ob2=new MyThreadTest1("MyThreadTest2");
             MyThreadTest1 ob3=new MyThreadTest1("MyThreadTest3");
             MyThreadTest1 ob4=new MyThreadTest1("MyThreadTest4");

             Thread t1=new Thread(ob1);
             Thread t2=new Thread(ob2);
             Thread t3=new Thread(ob3);
             Thread t4=new Thread(ob4);

             t1.start();
             t2.start();
             t3.start();
             t4.start();

         }
    }

