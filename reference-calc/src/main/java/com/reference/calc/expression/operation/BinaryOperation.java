package com.reference.calc.expression.operation;

import com.reference.calc.expression.Expression;

/**
 * Created by kapke on 21.11.15.
 */
public abstract class BinaryOperation extends Expression {
    private final Expression left;
    private final Expression right;

    public BinaryOperation (Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public abstract Double evaluate (Double left, Double right);

    public Double evaluate () {
        return this.evaluate(left.evaluate(), right.evaluate());
    }
}
