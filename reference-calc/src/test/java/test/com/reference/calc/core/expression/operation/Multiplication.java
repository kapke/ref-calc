package test.com.reference.calc.core.expression.operation;

import com.reference.calc.expression.operation.BinaryOperation;
import org.junit.Assert;
import org.junit.Test;
import test.com.reference.calc.core.helpers.HelperDoubleExpression;

/**
 * Created by kapke on 11.11.15.
 */
public class Multiplication {
    private BinaryOperation multiplication;

    public void setMultiplication (Double left, Double right) {
        multiplication = new com.reference.calc.expression.operation.Multiplication(new HelperDoubleExpression(left), new HelperDoubleExpression(right));
    }

    @Test
    public void positiveFactors () {
        Double expected = 6.0;
        setMultiplication(2.0, 3.0);
        Double actual1 = multiplication.evaluate();
        setMultiplication(3.0, 2.0);
        Double actual2 = multiplication.evaluate();
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void factorEqualToZero () {
        Double expected = 0.0;
        setMultiplication(0.0, 2.0);
        Double actual1 = multiplication.evaluate();
        setMultiplication(2.0, 0.0);
        Double actual2 = multiplication.evaluate();
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void negativeFactor () {
        Double expected = -6.0;
        setMultiplication(-2.0, 3.0);
        Double actual1 = multiplication.evaluate();
        setMultiplication(2.0, -3.0);
        Double actual2 = multiplication.evaluate();
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void negativeFactors () {
        Double expected = 6.0;
        setMultiplication(-2.0, -3.0);
        Double actual = multiplication.evaluate();
        Assert.assertEquals(expected, actual);
    }
}
