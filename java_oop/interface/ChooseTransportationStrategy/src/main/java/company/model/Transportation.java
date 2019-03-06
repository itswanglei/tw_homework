package main.java.company.model;

public abstract class Transportation implements ChooseStrategy {
    private double cost;

    public Transportation(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public boolean choose(double money, double cost) {
        return money >= cost;
    }
}
