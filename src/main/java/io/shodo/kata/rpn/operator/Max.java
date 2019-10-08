package io.shodo.kata.rpn.operator;

import io.shodo.kata.rpn.Expression;
import io.shodo.kata.rpn.Operands;

import java.util.Comparator;

public class Max implements Operator{
    @Override
    public OperatorType operatorType() {
        return OperatorType.AVAILABLE_NUMBERS;
    }

    @Override
    public Expression build(Operands operands) {
        return () ->
            operands
                .all()
                .stream()
                .map(Expression::eval)
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalStateException::new)
        ;
    }

    @Override
    public boolean hasSign(String token) {
        return "MAX".equals(token);
    }
}
