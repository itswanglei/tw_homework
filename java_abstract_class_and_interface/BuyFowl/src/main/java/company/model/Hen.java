package main.java.company.model;

public class Hen extends Fowl {
    public Hen() {
        super(3);
    }

    @Override
    public int setMaxQuantity(double money) {
        return (int) Math.floor(money / this.getPrice());
    }
}
