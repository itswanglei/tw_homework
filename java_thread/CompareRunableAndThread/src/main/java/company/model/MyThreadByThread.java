package main.java.company.model;

public class MyThreadByThread extends Thread {
    private String name;

    public int count = 7;

    public MyThreadByThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.name + " is running, count = " + count--);
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
