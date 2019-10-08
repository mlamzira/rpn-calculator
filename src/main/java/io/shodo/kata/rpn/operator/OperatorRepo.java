package io.shodo.kata.rpn.operator;

import java.util.List;

public class OperatorRepo {
    private List<Operator> operators = List.of(
        new Addition(),
        new Subtraction(),
        new Division(),
        new Multiplication(),
        new SquareRoot(),
        new Max()
    );

    public Operator operator(String token) {
        return operators.stream()
            .filter(op -> op.hasSign(token))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }
}
