package main.java.company;

import java.util.Optional;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(this.name);
    }
}
