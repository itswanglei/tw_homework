package main.java.model;

public abstract class Fowl {
    private final double price;

    public Fowl(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public abstract int setMaxQuantity(double money);
}
