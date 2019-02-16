package main.java.model;

public class Cock extends Fowl {
    public Cock() {
        super(5);
    }

    @Override
    public int setMaxQuantity(double money) {
        return (int) Math.floor(money / this.getPrice());
    }
}
