package main.java.company;

import main.java.company.model.Person;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Wang");
        person.setAge(25);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("./docs/Person.txt")))) {
            person.writeExternal(objectOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person personFromFile = new Person();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("./docs/Person.txt")))){
            personFromFile.readExternal(objectInputStream);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(personFromFile.getName().equals(person.getName()) && personFromFile.getAge() == person.getAge());
    }
}
