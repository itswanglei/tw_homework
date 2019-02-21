package main.java.company;

import java.lang.ref.SoftReference;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        TreeMap<Integer, String> treeMap = new TreeMap<>();
//        TreeMap<Integer, String> map =
//                new TreeMap<>(Comparator.reverseOrder());
//        map.put(3, "val");
//        map.put(2, "val");
//        map.put(1, "val");
//        map.put(5, "val");
//        map.put(4, "val");
//        System.out.println(map);
//
//        Map<Integer, String> hashMap = new HashMap<>();
//        hashMap.put(1, "val");
//        hashMap.put(2, "val");
//        hashMap.put(3, "val");
//        hashMap.put(4, "val");
//        hashMap.put(5, "val");
//        TreeMap<Integer, String> treeMap1 = new TreeMap<>(hashMap);
//        System.out.println(treeMap1);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "a");
        treeMap.put(2, "b");
        treeMap.put(3, "c");
        treeMap.put(4, "d");

        treeMap.remove(4);
        int sizeOfTreeMap = treeMap.size();

        treeMap.replace(2, "e");

        Map.Entry entry = treeMap.firstEntry();
        Integer key = treeMap.firstKey();
        entry = treeMap.lastEntry();
        key = treeMap.lastKey();
        String value = treeMap.get(3);
        SortedMap sortedMap = treeMap.headMap(2);
        sortedMap = treeMap.subMap(1, 3);

        Set setOfEntry = treeMap.entrySet();
        Collection<String> values = treeMap.values();
        System.out.println(values);
        treeMap.forEach((integer, s) -> System.out.println(integer + "->" + s));

        for (Map.Entry entry1 : treeMap.entrySet()) {
            System.out.println(entry1);
        }

        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
