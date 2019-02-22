package main.java.company;

import main.java.company.common.MyMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Instantiate myMap:");
        MyMap<Integer, String> myMap = new MyMap<>();
        myMap.printMyMap();

        System.out.println("\nJudge if myMap has the specified key:");
        System.out.println(myMap.containsKey(1));

        System.out.println("\nAdd element for myMap:");
        myMap.put(1, "a");
        myMap.put(2, "b");
        myMap.printMyMap();

        System.out.println("\nCalculate the size of myMap:");
        System.out.println(myMap.size());

        System.out.println("\nFind the specified map in myMap:");
        System.out.println(myMap.get(1));

        System.out.println("\nRemove the specified map in myMap:");
        System.out.println(myMap.remove(1));
        myMap.printMyMap();
        System.out.println(myMap.size());

        System.out.println("\nChange the value of the specified key:");
        System.out.println(myMap.replace(2, "a"));
        myMap.printMyMap();

        System.out.println("\nClear myMap:");
        myMap.clear();
        myMap.printMyMap();
        System.out.println(myMap.size());
    }
}
