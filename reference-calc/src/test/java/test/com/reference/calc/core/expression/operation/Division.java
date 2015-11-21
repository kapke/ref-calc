package test.com.reference.calc.core.expression.operation;

import com.reference.calc.expression.operation.BinaryOperation;
import org.junit.Assert;
import org.junit.Test;
import test.com.reference.calc.core.helpers.HelperDoubleExpression;

/**
 * Created by kapke on 11.11.15.
 */
public class Division {
    private BinaryOperation division;

    public void setDivision (Double left, Double right) {
        division = new com.reference.calc.expression.operation.Division(new HelperDoubleExpression(left), new HelperDoubleExpression(right));
    }

    @Test
    public void integerDivision () {
        setDivision(6.0, 3.0);
        Double expected = 2.0;
        Double actual = division.evaluate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dividendEqualToZero () {
        setDivision(0.0, 3.0);
        Double expected = 0.0;
        Double actual = division.evaluate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void divisorEqualToZero () {
        setDivision(2.0, 0.0);
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = division.evaluate();
        Assert.assertEquals(expected, actual);

        setDivision(-2.0, 0.0);
        expected = Double.NEGATIVE_INFINITY;
        actual = division.evaluate();
        Assert.assertEquals(expected, actual);
    }
}
