package com.reference.calc.core.operation;

/**
 * Created by kapke on 24.02.15.
 */
public class Multiplication implements Operation {
    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public double calc(double left, double right) {
        return left*right;
    }
}
