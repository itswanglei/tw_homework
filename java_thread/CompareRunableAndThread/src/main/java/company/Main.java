package main.java.company;

import main.java.company.model.MyThreadByRunable;
import main.java.company.model.MyThreadByThread;

public class Main {

    public static void main(String[] args) {
//        Runnable myThread1 = new MyThreadByRunable();
//        new Thread(myThread1, "Thread_1").start();
//        new Thread(myThread1, "Thread_2").start();
//        new Thread(myThread1, "Thread_3").start();

        MyThreadByThread myThread4 = new MyThreadByThread("Thread_4");
        MyThreadByThread myThread5 = new MyThreadByThread("Thread_5");
        MyThreadByThread myThread6 = new MyThreadByThread("Thread_6");
        myThread4.start();
        myThread5.start();
        myThread6.start();

    }
}
