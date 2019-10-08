package io.shodo.kata.rpn;

import io.shodo.kata.rpn.operator.Operator;

import java.util.*;

public class ExpressionStack {
    private Stack<Expression> expressionStack = new Stack<>();

    public Expression finalExpression() {

        if(expressionStack.size() > 1) {
            throw new IllegalStateException();
        }

        return expressionStack.pop();
    }

    public void push(Expression expression) {
        expressionStack.push(expression);
    }

    public Operands nPop(int numberOfOperands) {

        if(numberOfOperands == 0) {
            return new Operands(Collections.emptyList());
        }

        Expression[] expressions = new Expression[numberOfOperands];

        for (int i = 0; i < numberOfOperands; i++) {
            expressions[numberOfOperands - i - 1] = expressionStack.pop();
        }

        return new Operands(Arrays.asList(expressions));
    }

    public Operands operands(Operator.OperatorType operatorType) {
        switch (operatorType) {
            case UNARY:
                return nPop(1);
            case BINARY:
                return nPop(2);
            case AVAILABLE_NUMBERS:
                return availableNumbers();
        }

        return new Operands(Collections.emptyList());
    }

    private Operands availableNumbers() {
        List<Expression> expressions = new ArrayList<>();

        while(!expressionStack.isEmpty() && isaNumber(expressionStack.peek())) {
            expressions.add(expressionStack.pop());
        }

        return new Operands(expressions);
    }

    private boolean isaNumber(Expression expression) {
        return expression instanceof Number;
    }


}
