package main.java.company.model;

public class Context {
    private ChooseStrategy chooseStrategy;

    public Context(ChooseStrategy chooseStrategy) {
        this.chooseStrategy = chooseStrategy;
    }

    public boolean executeStategy(double money, double cost) {
        return chooseStrategy.choose(money, cost);
    }
}
