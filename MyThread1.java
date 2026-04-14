package Thread;

import MyPackage.Message;

 class MyThread1 implements Runnable {
     public void run() {
         for (int i = 1; i < 6; i++) {
             System.out.println("MyThread1 display" + i);
         }
     }

     public static void main(String[] args) {
         MyThread1 myThread1 = new MyThread1();
         Thread thread1 = new Thread(myThread1);
         thread1.start();
            }

    }

