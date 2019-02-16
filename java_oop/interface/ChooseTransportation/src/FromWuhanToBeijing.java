public class FromWuhanToBeijing implements Transportation {
    private final double costOfSelfDriving = 500;
    private final double costOfTakeBus = 300;
    private final double costOfTakeTrain = 400;
    private final double costOfTakePlane = 1000;

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
