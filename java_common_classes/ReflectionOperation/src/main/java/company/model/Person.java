package main.java.company.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final int age;
    private List<Person> friends;

    public Person() {
        this.name = null;
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "[name: " + this.name + ", age: " + this.age + "]";
    }

    public void beFriend(Person person) {
        this.friends.add(person);
    }

    public List<Person> getFriends() {
        return this.friends;
    }
}
