package main.java.company;

import main.java.company.model.*;

public class Main {

    public static void main(String[] args) {
        double money = 300;

        Transportation train = new Train(400);
        Transportation plane = new Plane(1000);
        Transportation bus = new Bus(300);
        Transportation selfDriving = new SelfDriving(400);

        if (new Context(train).executeStategy(money, train.getCost())) {
            System.out.println("小明可以从武汉坐火车到北京");
        }
        if (new Context(plane).executeStategy(money, plane.getCost())) {
            System.out.println("小明可以从武汉坐飞机到北京");
        }
        if (new Context(bus).executeStategy(money, bus.getCost())) {
            System.out.println("小明可以从武汉坐大巴到北京");
        }
        if (new Context(selfDriving).executeStategy(money, selfDriving.getCost())) {
            System.out.println("小明可以从武汉自驾到北京");
        }
    }
}
