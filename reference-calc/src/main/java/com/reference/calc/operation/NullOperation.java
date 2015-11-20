package com.reference.calc.operation;

/**
 * Created by kapke on 13.11.15.
 */
public class NullOperation implements Operation {

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public Double calc(double left, double right) {
        return null;
    }
}
