package com.reference.calc;

import com.reference.calc.operation.Addition;
import com.reference.calc.operation.Division;
import com.reference.calc.operation.Multiplication;
import com.reference.calc.operation.Subtraction;

/**
 * Created by kapke on 24.02.15.
 */
public class Main {
    public static void main (String[] args) {
        Calc calculator = new Calc();
        calculator.registerOperation(new Addition());
        calculator.registerOperation(new Division());
        calculator.registerOperation(new Multiplication());
        calculator.registerOperation(new Subtraction());
        ConsoleCalc consoleCalc = new ConsoleCalc();
        consoleCalc.run(calculator);
    }
}