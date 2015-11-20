package com.reference.calc;

import com.reference.calc.operation.NullOperation;
import com.reference.calc.operation.Operation;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kapke on 24.02.15.
 */
public class Calc {
    private List<Operation> operations;

    public Calc () {
        this.operations = new ArrayList<>();
    }

    public void registerOperation (Operation operation) {
        operations.add(operation);
    }

    public Double calculate(Double left, String symbol, Double right) {
        Operation operation  = findOperation(symbol);
        return operation.calc(left, right);
    }

    public Double calculate(String expression) {
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
