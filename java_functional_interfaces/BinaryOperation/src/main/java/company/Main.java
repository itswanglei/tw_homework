package main.java.company;

import main.java.company.model.BinaryOperation;

public class Main {

    public static void main(String[] args) {
        BinaryOperation<Integer, Integer> add = (a, b) -> a + b;
        BinaryOperation<Integer, Integer> minus = (a, b) -> a - b;
        BinaryOperation<Integer, Integer> multiply = (a, b) -> a * b;
        BinaryOperation<Integer, Integer> divide = (a, b) -> a / b;

        Integer a = 6;
        Integer b = 2;
        System.out.println("Add: " + calculate(add, a, b));
        System.out.println("Minus: " + calculate(minus, a, b));
        System.out.println("Multiply: " + calculate(multiply, a, b));
        System.out.println("Divide: " + calculate(divide, a, b));
    }

    public static Integer calculate(BinaryOperation<Integer, Integer> operation, Integer a, Integer b) {
        return operation.apply(a, b);
    }
}
