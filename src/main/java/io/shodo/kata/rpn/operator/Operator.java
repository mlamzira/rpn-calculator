package io.shodo.kata.rpn.operator;

import io.shodo.kata.rpn.Expression;
import io.shodo.kata.rpn.Operands;

public interface Operator {

    OperatorType operatorType();
    Expression build(Operands operands);
    boolean hasSign(String token);

    enum OperatorType {
        UNARY, BINARY, AVAILABLE_NUMBERS
    }
}
