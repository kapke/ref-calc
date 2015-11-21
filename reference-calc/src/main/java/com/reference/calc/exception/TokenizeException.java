package com.reference.calc.exception;

public class TokenizeException extends CalcException {
    public String expression;

    public TokenizeException(String expression) {
        super("Expression tokenizing failed:" + expression);
        this.expression = expression;
    }
}
