package com.reference.calc;

import com.reference.calc.expression.Expression;
import com.reference.calc.expression.Number;
import com.reference.calc.expression.operation.*;
import com.reference.calc.token.TokenInstance;

import java.util.List;

/**
 * Created by kapke on 21.11.15.
 */

public class ExpressionBuilder {
    public Expression buildExpression (TokenInstance root) {
        List<TokenInstance> params = root.getParams();
        switch (root.getType()) {
            case "expression":
                if(root.matchesPattern(new String[] {"opening_brace", "expression", "closing_brace"})) {
                    return buildExpression(params.get(1));
                }
            case "operation":
                return buildExpression(params.get(0));
            case "number":
                return buildNumber(root);
            case "operation_binary":
                return buildBinaryOperation(root);
        }

        return null;
    }

    private BinaryOperation buildBinaryOperation (TokenInstance operationToken) {
        TokenInstance realOperation = operationToken.getParams().get(0);
        List<TokenInstance> params = realOperation.getParams();
        switch (realOperation.getType()) {
            case "operation_binary_multiplication":
                return new Multiplication(this.buildExpression(params.get(0)), this.buildExpression(params.get(2)));
            case "operation_binary_division":
                return new Division(this.buildExpression(params.get(0)), this.buildExpression(params.get(2)));
            case "operation_binary_addition":
                return new Addition(this.buildExpression(params.get(0)), this.buildExpression(params.get(2)));
            case "operation_binary_subtraction":
                return new Subtraction(this.buildExpression(params.get(0)), this.buildExpression(params.get(params.size()-1)));
        }

        return null;
    }

    private Number buildNumber (TokenInstance numberToken) {
        String numberValue = numberToken.getValue();
        return new Number(numberValue.replace("(", "").replace(")", ""));
    }
}
