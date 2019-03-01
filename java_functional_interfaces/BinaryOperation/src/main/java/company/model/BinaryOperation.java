package main.java.company.model;

@FunctionalInterface
public interface BinaryOperation<T, R> {
    T binaryOperation(R a, R b);
}
