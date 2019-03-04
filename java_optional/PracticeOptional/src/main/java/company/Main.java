package main.java.company;

import java.util.Optional;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());

        String name = "Wang";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.toString());

        System.out.println(Optional.ofNullable(name).toString());
        System.out.println(Optional.ofNullable(null).toString());

        opt.ifPresent(System.out::println);

        String nullName = null;
        name = Optional.ofNullable(nullName).orElse("Zhang");
        System.out.println(name);

        name = Optional.ofNullable(nullName).orElseGet(() -> "Li");
        System.out.println(name);

//        name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);

        System.out.println(opt.get());

        Person person = new Person("Zhao", 20);
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        boolean result = optionalPerson.map(Person::getAge)
                .filter(age -> age < 25)
                .isPresent();
        System.out.println(result);

        name = optionalPerson.flatMap(Person::getName).orElse("");
        System.out.println(name);

        String[] names = new String[]{"zhang", "wang", "li", "zhao", "wu"};
        name = Optional.of("wang").orElse(getRandomName(names));
        name = Optional.of("wang").orElseGet(() -> getRandomName(names));

    }

    public static String getRandomName(String[] names) {
        System.out.println("Generating a name...");
        Random random = new Random();
        return names[random.nextInt(5)];
    }
}
