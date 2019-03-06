package main.java.company.model;

@FunctionalInterface
public interface BinaryOperation<T, R> {
    T apply(R a, R b);
}
