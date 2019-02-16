package main.java.company.model;

public class Chick extends Fowl {
    public Chick() {
        super(0.33);
    }

    @Override
    public int setMaxQuantity(double money) {
        return (int) money * 3;
    }
}
