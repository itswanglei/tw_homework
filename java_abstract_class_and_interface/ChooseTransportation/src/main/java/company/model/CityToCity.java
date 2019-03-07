package main.java.company.model;

public class CityToCity implements Transportation {
    private String departure;
    private String destination;
    private double costOfSelfDriving;
    private double costOfTakeBus;
    private double costOfTakeTrain;
    private double costOfTakePlane;

    public CityToCity(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    public void setCostOfSelfDriving(double costOfSelfDriving) {
        this.costOfSelfDriving = costOfSelfDriving;
    }

    public void setCostOfTakeBus(double costOfTakeBus) {
        this.costOfTakeBus = costOfTakeBus;
    }

    public void setCostOfTakePlane(double costOfTakePlane) {
        this.costOfTakePlane = costOfTakePlane;
    }

    public void setCostOfTakeTrain(double costOfTakeTrain) {
        this.costOfTakeTrain = costOfTakeTrain;
    }

    @Override
    public boolean takeSelfDriving(double money) {
        return money >= this.costOfSelfDriving;
    }

    @Override
    public boolean takeBus(double money) {
        return money >= this.costOfTakeBus;
    }

    @Override
    public boolean takeTrain(double money) {
        return money >= this.costOfTakeTrain;
    }

    @Override
    public boolean takePlane(double money) {
        return money >= this.costOfTakePlane;
    }
}
