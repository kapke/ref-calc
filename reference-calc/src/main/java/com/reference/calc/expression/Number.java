package com.reference.calc.expression;

/**
 * Created by kapke on 21.11.15.
 */
public class Number extends Expression {
    private final String val;

    public Number (String val) {
        this.val = val;
    }
    @Override
    public Double evaluate() {
        return Double.parseDouble(val);
    }
}
