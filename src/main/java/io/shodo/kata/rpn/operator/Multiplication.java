package io.shodo.kata.rpn.operator;

import io.shodo.kata.rpn.Expression;
import io.shodo.kata.rpn.Operands;

public class Multiplication implements Operator{
    @Override
    public OperatorType operatorType() {
        return OperatorType.BINARY;
    }

    @Override
    public Expression build(Operands operands) {
        return () -> operands.first().eval() * operands.second().eval();
    }

    @Override
    public boolean hasSign(String token) {
        return "*".equals(token);
    }
}
