package main.java.company;

import main.java.company.common.Entry;
import main.java.company.common.MyMapImpl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Instantiate myMap:");
        MyMapImpl<Integer, String> myMap = new MyMapImpl<>();
        System.out.println(myMap);

        System.out.println("\nJudge if myMap has the specified key:");
        System.out.println(myMap.containsKey(1));

        System.out.println("\nAdd element for myMap:");
        myMap.put(1, "a");
        myMap.put(2, "b");
        System.out.println(myMap);

        System.out.println("\nCalculate the size of myMap:");
        System.out.println(myMap.size());

        System.out.println("\nFind the specified map in myMap:");
        System.out.println(myMap.get(1));

        System.out.println("\nRemove the specified map in myMap:");
        System.out.println(myMap.remove(1));
        System.out.println(myMap);
        System.out.println(myMap.size());

        System.out.println("\nChange the value of the specified key:");
        System.out.println(myMap.replace(2, "a"));
        System.out.println(myMap);

        System.out.println("\nJudge if the map has the specified value:");
        System.out.println(myMap.containsValue("a"));

        System.out.println("\nClear myMap:");
        myMap.clear();
        System.out.println(myMap);
        System.out.println(myMap.size());

        System.out.println("\nTraversing myMap:");
        myMap.put(1, "a");
        myMap.put(2, "b");
        myMap.put(3, "c");
        for (Entry entry : myMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("\nAdd more elements to myMap:");
        myMap.put(4, "d");
        myMap.put(5, "d");
        myMap.put(6, "d");
        myMap.put(7, "d");
        myMap.put(8, "d");
        myMap.put(9, "d");
        myMap.put(10, "d");
        myMap.put(11, "d");
        myMap.put(12, "d");
        myMap.put(13, "d");
        myMap.put(14, "d");
        myMap.put(15, "d");
        myMap.put(16, "d");
        myMap.put(17, "d");
        myMap.put(18, "d");
        myMap.put(19, "d");
        myMap.put(20, "d");
        System.out.println(myMap);

        System.out.println("\nTest constructor with parameters:");
        MyMapImpl newMap = new MyMapImpl(20, 0.8);
        System.out.println(newMap);
    }
}
