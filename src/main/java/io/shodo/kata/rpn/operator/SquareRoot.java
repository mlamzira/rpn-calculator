package io.shodo.kata.rpn.operator;

import io.shodo.kata.rpn.Expression;
import io.shodo.kata.rpn.Operands;

public class SquareRoot implements Operator{
    @Override
    public OperatorType operatorType() {
        return OperatorType.UNARY;
    }

    @Override
    public Expression build(Operands operands) {
        return () -> (int) Math.sqrt(operands.first().eval());
    }

    @Override
    public boolean hasSign(String token) {
        return "SQRT".equals(token);
    }
}
