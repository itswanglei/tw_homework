package main.java.company.model;

public class Chick extends Fowl {
    public Chick() {
        super(1 / 3);
    }

    @Override
    public int setMaxQuantity(double money) {
        return (int) Math.floor(money / this.getPrice());
    }
}
