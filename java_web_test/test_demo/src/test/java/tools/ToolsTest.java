package tools;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
}
