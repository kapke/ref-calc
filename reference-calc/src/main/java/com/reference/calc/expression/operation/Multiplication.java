package com.reference.calc.expression.operation;

import com.reference.calc.expression.Expression;

/**
 * Created by kapke on 24.02.15.
 */
public class Multiplication extends BinaryOperation {

    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Double evaluate(Double left, Double right) {
        return left*right;
    }
}
