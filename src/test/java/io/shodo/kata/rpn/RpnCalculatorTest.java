package io.shodo.kata.rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnCalculatorTest {

    @Test
    public void shouldReturnTheSameDigitIfNoOperationProvided() {

        assertThat(eval("0")).isEqualTo("0");
        assertThat(eval("1")).isEqualTo("1");
        assertThat(eval("2")).isEqualTo("2");
        assertThat(eval("3")).isEqualTo("3");
    }

    @Test
    public void shouldReturnTheSumOfTwoParameters() {
        assertThat(eval("0 1 +")).isEqualTo("1");
        assertThat(eval("1 10 +")).isEqualTo("11");
        assertThat(eval("55 70 +")).isEqualTo("125");
    }

    @Test
    public void shouldReturnTheSumOfThreeParameters() {
        assertThat(eval("1 1 1 + +")).isEqualTo("3");
        assertThat(eval("1 2 3 4 + + +")).isEqualTo("10");
    }

    @Test
    public void mixedOperations() {
        assertThat(eval("4 2 + 3 -")).isEqualTo("3");
        assertThat(eval("1 1 + 1 +")).isEqualTo("3");
        assertThat(eval("3 5 8 * 7 + *")).isEqualTo("141");
    }

    @Test
    public void unaryOperatorSquareRoot() {
        assertThat(eval("9 SQRT")).isEqualTo("3");
    }

    @Test
    public void max() {
        assertThat(eval("5 3 4 2 9 1 MAX")).isEqualTo("9");
        assertThat(eval("4 5 MAX 1 2 MAX *")).isEqualTo("10");
    }

    private String eval(String input) {
        return new RpnCalculator().eval(input);
    }

}
