package com.reference.calc.operation;

/**
 * Created by kapke on 24.02.15.
 */
public interface Operation {
    public String getSymbol();
    public double calc(double left, double right);
}
