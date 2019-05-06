package tools;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tools {

    public int getFibonacciSequence(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }

        if (2 == number || 1 == number) {
            return 1;
        }

        return getFibonacciSequence(number - 1) + getFibonacciSequence(number - 2);
    }

    public List<Integer> orderIntegerArray(int[] array) {
        return Arrays.stream(array).boxed().sorted().collect(Collectors.toList());
    }

    public int sumEven(int[] array) {
        return Arrays.stream(array).boxed().filter(e -> 0 == e % 2).reduce(0, Integer::sum);
    }
}
