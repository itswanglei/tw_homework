package main.java.company.model;

public interface Transportation {
    boolean takeSelfDriving(double money);

    boolean takeBus(double money);

    boolean takeTrain(double money);

    boolean takePlane(double money);
}
