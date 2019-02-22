package main.java.company;

import main.java.company.common.MyMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Instantiate myMap:");
        MyMap<Integer, String> myMap = new MyMap<>();
        myMap.printMyMap();

        System.out.println("\nAdd element for myMap:");
        myMap.put(1, "a");
        myMap.put(2, "b");
        myMap.printMyMap();

        System.out.println("\nCalculate the size of myMap:");
        myMap.size();
    }
}
