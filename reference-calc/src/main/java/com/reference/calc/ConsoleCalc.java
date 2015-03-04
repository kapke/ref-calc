package com.reference.calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by kapke on 24.02.15.
 */
public class ConsoleCalc {
    public void run (Calc calc) {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Double left = Double.parseDouble(inputReader.readLine());
            String symbol = inputReader.readLine();
            Double right = Double.parseDouble(inputReader.readLine());
            Double result = calc.calculate(left, symbol, right);
            System.out.println("Ala ma kota");
            if(result != null) {
                System.out.println(result);
            } else {
                System.out.println("Operation failed or not found");
            }
        } catch (Exception e) {
            System.out.println("There was error during execution:");
            System.out.println(e.getMessage());
        }
    }
}
