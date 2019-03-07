package main.java.company;

import main.java.company.model.CityToCity;

public class Main {

    public static void main(String[] args) {
        CityToCity cityToCity = new CityToCity("武汉", "北京");
        cityToCity.setCostOfSelfDriving(500);
        cityToCity.setCostOfTakeBus(300);
        cityToCity.setCostOfTakePlane(1000);
        cityToCity.setCostOfTakeTrain(400);

        int money = 300;
        boolean canSelfDriving = cityToCity.takeSelfDriving(money);
        boolean canTakeBus = cityToCity.takeBus(money);
        boolean canTakeTrain = cityToCity.takeTrain(money);
        boolean canTakePlane = cityToCity.takePlane(money);

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
