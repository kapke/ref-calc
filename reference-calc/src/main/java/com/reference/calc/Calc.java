package com.reference.calc;

import com.reference.calc.exception.CalcException;
import com.reference.calc.operation.NullOperation;
import com.reference.calc.operation.Operation;
import com.reference.calc.token.Token;
import com.reference.calc.token.TokenInstance;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    private List<Operation> operations;
    private Tokenizer tokenizer;

    public Calc () {
        this.operations = new ArrayList<>();
        this.tokenizer = new Tokenizer();
    }

    public void registerOperation (Operation operation) {
        operations.add(operation);
    }

    public Double calculate(Double left, String symbol, Double right) {
        Operation operation  = findOperation(symbol);
        return operation.calc(left, right);
    }

    public Double calculate(String expression) throws CalcException {
        System.out.println(expression);
        List<TokenInstance> tokens = tokenizer.tokenize(expression);
        for(TokenInstance token: tokens) {
            System.out.print(token.getType()+", ");
            System.out.println(token.getValue());
        }
        System.out.println("");

        String[] parts = expression.split("\\s+");
        Double left = extractNumber(parts[0]);
        String symbol = parts[1];
        Double right = extractNumber(parts[2]);
        return calculate(left, symbol, right);
    }

    protected Operation findOperation(String symbol) {
        for(Operation operation : operations) {
            if(operation.getSymbol().equals(symbol)) {
                return operation;
            }
        }
        return new NullOperation();
    }

    private Double extractNumber (String part) {
        return Double.parseDouble(part.replace("(", "").replace(")", ""));
    }
}
