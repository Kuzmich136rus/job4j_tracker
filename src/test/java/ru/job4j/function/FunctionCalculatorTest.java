package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(4, 8, x -> ((x * x) - x - 2));
        List<Double> expected = Arrays.asList(10D, 18D, 28D, 40D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenIndicativeFunctionTnenIndicativeResult() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(-3, 2, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(0.125D, 0.25D, 0.5D, 2D, 2D);
        assertThat(result).containsAll(expected);
    }
}