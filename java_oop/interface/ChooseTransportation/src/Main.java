public class Main {

    public static void main(String[] args) {
        FromWuhanToBeijing fromWuhanToBeijing = new FromWuhanToBeijing();

        int money = 300;
        boolean canSelfDriving = fromWuhanToBeijing.takeSelfDriving(money);
        boolean canTakeBus = fromWuhanToBeijing.takeBus(money);
        boolean canTakeTrain = fromWuhanToBeijing.takeTrain(money);
        boolean canTakePlane = fromWuhanToBeijing.takePlane(money);

        if (canSelfDriving) {
            System.out.println("小明可以从武汉自驾到北京");
        }

        if (canTakeBus) {
            System.out.println("小明可以从武汉坐大巴到北京");
        }

        if (canTakeTrain) {
            System.out.println("小明可以从武汉坐火车到北京");
        }

        if (canTakePlane) {
            System.out.println("小明可以从武汉坐飞机到北京");
        }
    }
}
