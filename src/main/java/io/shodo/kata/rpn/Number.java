package io.shodo.kata.rpn;

public class Number implements Expression {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }
}
