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
        // 创建stream的几种方式
        Stream<String> emptyStream = Stream.empty();

        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> streamFromCollection = collection.stream();

        String[] array = new String[]{"a", "b", "c", "d"};
        Stream<String> StreamFromArray = Arrays.stream(array);

        Stream<Integer> streamByBuilder = Stream.<Integer>builder().add(100).add(200).build();

        Stream<String> streamByGenerate = Stream.generate(() -> "element").limit(3);

        Stream<Integer> streamByIterate = Stream.iterate(2, i -> i * i).limit(4);

        IntStream streamByRange = IntStream.range(1, 9);
        IntStream streamByRangeClosed = IntStream.rangeClosed(1, 9);

        Random random = new Random();
        DoubleStream streamByRandom = random.doubles(3);

        IntStream streamOfChars = "ThoughtWorks".chars();

        Path path = Paths.get("./docs/text.txt");
        try {
            Stream<String> streamFromFile = Files.lines(path);
            streamFromFile.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<String> streamByOf = Stream.of("abcd", "bbcd", "cbcd");


        // 使用Stream和Lambda表达式操作集合
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 5, 4, 3};
        List<Integer> list = Arrays.asList(integers);

        boolean isAllMatch = list.stream().allMatch(Objects::nonNull);

        boolean isAnyMatch = list.stream().anyMatch(integer -> integer > 3);

        boolean nonMathch = list.stream().noneMatch(Objects::isNull);

        long size = list.stream().count();

        int firstElment = list.stream().findFirst().get();

        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());

        List<Integer> evenElements = list.stream().filter(i -> 0 == i % 2).collect(Collectors.toList());

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

        list.stream().skip(2).forEach(System.out::println);

        List orderedList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());


        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"),
                new Product(25, "beef"));

        Map<Integer, List<Product>> productMap = productList.stream().collect(Collectors.groupingBy(Product::getPrice));
        System.out.println(productMap);

        Map<Boolean, List<Product>> seperateByPrice = productList.stream().collect(Collectors.partitioningBy(item -> item.getPrice() > 14));
        System.out.println(seperateByPrice.get(false)
                .stream()
                .map(Product::getName)
                .collect(Collectors.joining(",", "[", "]")));


    }
}
