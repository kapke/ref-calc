package com.reference.calc.exception;

public class ParseErrorException extends CalcException {
    public String expression;

    public ParseErrorException(String expression) {
        super("Expression parse failed:" + expression);
        this.expression = expression;
    }
}
