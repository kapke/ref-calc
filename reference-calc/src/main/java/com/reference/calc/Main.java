package com.reference.calc;

import com.reference.calc.expression.operation.Addition;
import com.reference.calc.expression.operation.Division;
import com.reference.calc.expression.operation.Multiplication;
import com.reference.calc.expression.operation.Subtraction;

/**
 * Created by kapke on 24.02.15.
 */
public class Main {
    public static void main (String[] args) {
        Calc calculator = new Calc();
        ConsoleCalc consoleCalc = new ConsoleCalc();
        consoleCalc.run(calculator);
    }
}
