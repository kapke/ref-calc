package com.reference.calc;

import com.reference.calc.exception.CalcException;
import com.reference.calc.expression.Expression;
import com.reference.calc.token.TokenInstance;

import java.util.List;

public class Calc {
    private final Parser parser;
    private final ExpressionBuilder expressionBuilder;
    private Scanner scanner;

    public Calc () {
        this.scanner = new Scanner();
        this.parser = new Parser();
        this.expressionBuilder = new ExpressionBuilder();
    }

    public Double calculate(String expression) throws CalcException {
        List<TokenInstance> tokens = scanner.tokenize(expression);
        tokens = scanner.sanitize(tokens);
        TokenInstance root = parser.parse(tokens);
        Expression rootExpression = expressionBuilder.buildExpression(root);

        System.out.println("");
        return rootExpression.evaluate();
    }
}
