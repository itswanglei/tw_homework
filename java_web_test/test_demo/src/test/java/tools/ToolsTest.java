package tools;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolsTest {

    private Tools tools = new Tools();

    @Test(expected = IllegalArgumentException.class)
    public void test_fibonacci_sequence_return_exception_when_less_1() {
        this.tools.getFibonacciSequence(0);
    }

    @Test
    public void test_fibonacci_sequence_return_1_when_1() {
        int result = this.tools.getFibonacciSequence(1);
        assertEquals(1, result);
    }

    @Test
    public void test_fibonacci_sequence_return_1_when_2() {
        int result = this.tools.getFibonacciSequence(2);
        assertEquals(1, result);
    }

    @Test
    public void test_fibonacci_sequence_return_2_when_3() {
        int result = this.tools.getFibonacciSequence(3);
        assertEquals(2, result);
    }

    @Test
    public void test_fibonacci_sequence_return_8_when_6() {
        int result = this.tools.getFibonacciSequence(6);
        assertEquals(8, result);
    }

    @Test
    public void test_order_integer_array_when_array_length_is_0() {
        int[] array = {1};
        List<Integer> result = this.tools.orderIntegerArray(array);

        List<Integer> expect = new ArrayList<>();
        expect.add(1);

        assertEquals(expect, result);
    }

    @Test
    public void test_order_integer_array_when_array_length_more_than_1() {
        int[] array = {1, 8, 2, 7, 5, 13};
        List<Integer> result = this.tools.orderIntegerArray(array);

        Integer[] expectArray = new Integer[]{1, 2, 5, 7, 8, 13};
        List<Integer> expect = Arrays.asList(expectArray);

        assertEquals(expect, result);
    }

    @Test
    public void test_sum_even_when_array_only_has_odd() {
        int[] array = {5, 7};
        int result = this.tools.sumEven(array);
        assertEquals(0, result);
    }

    @Test
    public void test_sum_even_when_array_only_has_even() {
        int[] array = {4, 6};
        int result = this.tools.sumEven(array);
        assertEquals(10, result);
    }

    @Test
    public void test_sum_even_when_array_has_even_and_odd() {
        int[] array = {1, 2, 3, 4};
        int result = this.tools.sumEven(array);
        assertEquals(6, result);
    }
}
