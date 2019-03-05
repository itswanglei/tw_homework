package main.java.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        Stream<String> stringStream = Stream.empty();
//        stringStream.forEach(System.out::println);
//
//        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);
//        Stream<Integer> integerStream = collection.stream();
//        integerStream.forEach(System.out::println);
//
//        String[] array = new String[]{"a", "b", "c", "d"};
//        stringStream = Arrays.stream(array);
//        stringStream.forEach(System.out::println);
//
//        Stream.<Integer>builder().add(100).add(200).build().forEach(System.out::println);
//
//        Stream.generate(() -> "element").limit(3).forEach(System.out::println);
//
//        Stream.iterate(2, i -> i * i).limit(4).forEach(System.out::println);
//
//        IntStream intStream = IntStream.range(1, 9); //rangeClosed
//        intStream.forEach(System.out::println);
//
//        Random random = new Random();
//        DoubleStream doubleStream = random.doubles(3);
//        doubleStream.forEach(System.out::println);
//
//        IntStream streamOfChars = "ThoughtWorks".chars();
//        streamOfChars.forEach(System.out::println);
//
//        Path path = Paths.get("./docs/text.txt");
//        try {
//            Stream<String> streamOfStrings = Files.lines(path);
//            streamOfStrings.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
//        onceModifiedStream.forEach(System.out::println);
//
//        int sum = Stream.iterate(1, i -> i++)
//                .limit(5 - 1 + 1)
//                .filter(item -> 0 == item % 2)
//                .mapToInt(Integer::valueOf)
//                .sum();
//        System.out.println(sum);
//
//        Stream.iterate(1, i -> i + 1)
//                .limit(5 - 1 + 1)
//                .filter(item -> 0 == item % 2)
//                .forEach(System.out::println);

//                List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
//                new Product(14, "orange"),
//                new Product(13, "lemon"),
//                new Product(23, "bread"),
//                new Product(13, "sugar"),
//                new Product(25, "beef"));
//
//        String listToString = productList.stream()
//                .map(Product::getName)
//                .collect(Collectors.joining(", ", "[", "]"));
//
//        System.out.println(listToString);
//
//        double averagePrice = productList.stream().collect(Collectors.averagingDouble(Product::getPrice));
//        System.out.println(averagePrice);
//
//        int totalPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));
//        System.out.println(totalPrice);
//
//        IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getPrice));
//        System.out.println(statistics);
//        System.out.println(statistics.getMax());
//        System.out.println(statistics.getMin());
//        System.out.println(statistics.getAverage());
//        System.out.println(statistics.getSum());
//        System.out.println(statistics.getCount());
//
//        Map<Integer, List<Product>> productMap = productList.stream().collect(Collectors.groupingBy(Product::getPrice));
//        System.out.println(productMap);
//
//        Map<Boolean, List<Product>> seperateByPrice = productList.stream().collect(Collectors.partitioningBy(item -> item.getPrice() > 14));
//        System.out.println(seperateByPrice.get(false)
//                .stream()
//                .map(Product::getName)
//                .collect(Collectors.joining(",", "[", "]")));


        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 5, 4, 3};
        List<Integer> list = Arrays.asList(integers);

        boolean isAllMatch = list.stream().allMatch(Objects::nonNull);

        boolean isAnyMatch = list.stream().anyMatch(integer -> integer > 3);

        boolean nonMathch = list.stream().noneMatch(Objects::isNull);

        long size = list.stream().count();

        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());

        List<Integer> evenElements = list.stream().filter(i -> 0 == i % 2).collect(Collectors.toList());

        int firstElment = list.stream().findFirst().get();

        List<Integer> doubleList = list.stream().map(i -> i * i).collect(Collectors.toList());

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List flatList = inputStream.flatMap(Collection::stream).collect(Collectors.toList());

        list.forEach(System.out::println);

        int maximum = list.stream().max(Comparator.comparing(Integer::valueOf)).get();

        int minimum = list.stream().min(Comparator.comparing(Integer::valueOf)).get();

        double average = list.stream().collect(Collectors.averagingDouble(Integer::valueOf));

        long summary = list.stream().reduce(0, (acc, cur) -> acc + cur);

        summary = list.stream().mapToInt(Integer::valueOf).sum();

        summary = list.stream().collect(Collectors.summingInt(Integer::valueOf));

        IntSummaryStatistics statistics = list.stream().collect(Collectors.summarizingInt(Integer::valueOf));
        size = statistics.getCount();
        maximum = statistics.getMax();
        minimum = statistics.getMin();
        average = statistics.getAverage();
        summary = statistics.getSum();

        Map<Integer, List<Integer>> map1 = list.stream().collect(Collectors.groupingBy(i -> i * i));

        Map<Boolean, List<Integer>> map2 = list.stream().collect(Collectors.partitioningBy(i -> i > 3));
        List integer = map2.get(true);

        list.stream().skip(2).forEach(System.out::println);

        List orderedList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

    }
}
