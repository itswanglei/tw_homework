package tools;

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
}
