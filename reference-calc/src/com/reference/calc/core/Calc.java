package com.reference.calc.core;

import com.reference.calc.core.operation.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kapke on 24.02.15.
 */
public class Calc {
    private List<Operation> operations;

    public Calc () {
        this.operations = new ArrayList<>();
    }

    public void registerOperation (Operation operation) {
        this.operations.add(operation);
    }

    public Double calculate(Double left, String symbol, Double right) {
        Operation operation  = this.findOperation(symbol);
        if(operation != null) {
            return operation.calc(left, right);
        } else {
            return null;
        }
    }

    protected Operation findOperation(String symbol) {
        for(Operation operation : this.operations) {
            if(operation.getSymbol().equals(symbol)) {
                return operation;
            }
        }
        return null;
    }
}
