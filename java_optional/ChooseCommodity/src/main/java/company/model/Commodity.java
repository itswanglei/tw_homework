package main.java.company.model;

public class Commodity {
    private final int id;
    private final String name;
    private final double price;

    public Commodity(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
