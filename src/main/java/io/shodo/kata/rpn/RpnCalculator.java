package io.shodo.kata.rpn;

import io.shodo.kata.rpn.operator.Operator;
import io.shodo.kata.rpn.operator.OperatorRepo;

public class RpnCalculator {

    private final ExpressionStack expressionStack = new ExpressionStack();
    private final OperatorRepo operatorRepo = new OperatorRepo();

    public String eval(String expr) {
        String[] tokens = expr.split(" ");

        for (String token : tokens) {
            Expression expression = getExpression(token);
            expressionStack.push(expression);
        }

        Expression finalExpression = expressionStack.finalExpression();
        return Integer.toString(finalExpression.eval());
    }

    private Expression getExpression(String token) {

        if(isNumeric(token)) {
            return new Number(Integer.parseInt(token));
        }

        Operator operator = operatorRepo.operator(token);
        Operands operands = expressionStack.operands(operator.operatorType());

        return operator.build(operands);

    }

    private boolean isNumeric(String token) {
        return token.matches("\\d+");
    }

}

