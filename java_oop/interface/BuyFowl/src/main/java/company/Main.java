package main.java.company;

import main.java.company.model.Chick;
import main.java.company.model.Cock;
import main.java.company.model.Fowl;
import main.java.company.model.Hen;
import main.java.company.tools.Print;

public class Main {

    public static void main(String[] args) {
        double money = 100;
        int total = 100;

        Print print = new Print();

        Fowl cock = new Cock();
        Fowl hen = new Hen();
        Fowl chick = new Chick();

        final int maxCock = cock.setMaxQuantity(money);
        final int mxHen = hen.setMaxQuantity(money);

        for (int cockQuantity = 1; cockQuantity < maxCock; cockQuantity++) {
            for (int henQuantity = 1; henQuantity < mxHen; henQuantity++) {
                int chickQuantity = total - cockQuantity - henQuantity;
                if (chickQuantity % 3 == 0 && cockQuantity * cock.getPrice() + henQuantity * hen.getPrice() + chickQuantity / 3 == money) {
                    print.printResult(cockQuantity, henQuantity, chickQuantity);
                }
            }
        }
    }

}
