package main.java.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        boolean result = linkedList.add("a");
        linkedList.addFirst("z");
        linkedList.add(1, "b");

        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("d");
        list.add("a");
        result = linkedList.addAll(list);

        String firstElement = linkedList.remove();
        String specifiedIndexElement = linkedList.remove(3);
        result = linkedList.remove("a");

        result = linkedList.contains("b");
        String specifiedElement = linkedList.get(2);
        String lastElement = linkedList.getLast();
        int index = linkedList.indexOf("b");

        String element = linkedList.set(1, "a");
        int sizeOfLinkedList = linkedList.size();
        Object[] elements = linkedList.toArray();

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        for (String s : linkedList) {
            System.out.println(s);
        }

        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }



//        System.out.println(linkedList);


    }
}
