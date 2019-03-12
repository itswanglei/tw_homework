package main.java.company;

import main.java.company.model.Person;
import main.java.company.tools.ClassUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("zhang", 23);
        Person person2 = new Person("wang", 23);


        ClassUtil classUtil = new ClassUtil();
        ClassUtil.printMethodMessage(person1);
        ClassUtil.printFieldMessage(person1);
        ClassUtil.printConMessage(person1);

        Class clazz = person1.getClass();
        try {
            Method method = clazz.getMethod("beFriend", Person.class);
            Object object = method.invoke(person1, person2);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(person1.getFriends());

        try {
            Class personClass = Class.forName("main.java.company.model.Person");
            Object personObject = personClass.newInstance();
            Person person = (Person) personObject;

            Field name = personClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person, "li");

            Field age = personClass.getDeclaredField("age");
            age.setAccessible(true);
            age.set(person, 20);

            System.out.println(person);
        } catch (ClassNotFoundException |
                IllegalAccessException |
                InstantiationException |
                NoSuchFieldException e) {
            e.printStackTrace();
        }

        Class clazz2 = Person.class;
        try {
            Constructor constructor = clazz2.getConstructor(String.class, int.class);
            Person person3 = (Person) constructor.newInstance("zhao", 19);
            System.out.println(person3);
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

        ArrayList list = new ArrayList();
//        list.add("hello"); // Unchecked call to 'add(E)' as a member of raw type 'java.util.ArrayList'
        Class c = list.getClass();
        //反射的操作都是编译之后的操作
        try {
            Method m = c.getMethod("add",Object.class);
            m.invoke(list,20);
            //绕过编译操作就绕过了泛型
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
