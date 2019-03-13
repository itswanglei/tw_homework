package main.java.company;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class Main {

    public static void main(String[] args) {

        // 构造函数
        HashMap<Integer, String> hashMap = new HashMap<>();

        // 增添元素
        hashMap.put(1, "a");
        hashMap.put(2, "b");
        hashMap.put(10, "c");
        hashMap.put(13, "d");
        hashMap.put(20, "e");
        hashMap.put(19, "f");

        // 其他方法
        int sizeOfHashMap = hashMap.size();
        boolean isEmpty = hashMap.isEmpty();

        // 删除元素
        hashMap.remove(13);

        // 修改元素
        hashMap.replace(10, "z");

        // 查找元素
        boolean isContained = hashMap.containsKey(13);
        isContained = hashMap.containsValue("f");
        String element = hashMap.get(20);

        // 遍历接口
        System.out.println("遍历接口：");
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());

        // 两种遍历方法
        System.out.println("\nfor循环遍历：");
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("\n迭代器遍历：");
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 按值排序
        System.out.println("\n按值排序：");
        HashMap sortedMap = sortByValues(hashMap);
        sortedMap.entrySet().forEach(System.out::println);
    }

    public static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
//        list.sort((o1, o2) -> ((Comparable) ((Map.Entry) o1).getValue())
//                .compareTo(((Map.Entry) o2).getValue()));
        list.sort(comparingByValue());
        HashMap sortedMap = new LinkedHashMap();
        for (Object o : list) {
            Map.Entry entry = (Map.Entry) o;
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
