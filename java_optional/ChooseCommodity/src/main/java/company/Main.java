package main.java.company;

import main.java.company.model.Commodity;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Commodity cellphone1 = new Commodity(0001, "手机", 1500);
        Commodity cellphone2 = new Commodity(0002, "手机", 2500);
        Commodity watch = new Commodity(0003, "手表", 1500);

        System.out.println("ID-" + cellphone1.getId() + " is the wanted item: " + isWanted(cellphone1));
        System.out.println("ID-" + cellphone2.getId() + " is the wanted item: " + isWanted(cellphone2));
        System.out.println("ID-" + watch.getId() + " is the wanted item: " + isWanted(watch));
    }

    public static boolean isWanted(Commodity commodity) {
        return Optional.ofNullable(commodity)
                .filter(item -> item.getName().equals("手机"))
                .filter(item -> item.getPrice() <= 2000)
                .filter(item -> item.getPrice() >= 1000)
                .isPresent();
    }
}
