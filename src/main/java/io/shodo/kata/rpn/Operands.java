package io.shodo.kata.rpn;

import java.util.List;

public class Operands {

    private final List<Expression> expressions;

    public Operands(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public Expression first() {
        return expressions.get(0);
    }

    public Expression second() {
        return expressions.get(1);
    }

    public List<Expression> all() {
        return List.copyOf(expressions);
    }
}
