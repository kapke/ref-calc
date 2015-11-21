package test.com.reference.calc.core.expression.operation;

import com.reference.calc.expression.operation.BinaryOperation;
import org.junit.Assert;
import org.junit.Test;
import test.com.reference.calc.core.helpers.HelperDoubleExpression;

/**
 * Created by kapke on 11.11.15.
 */
public class Subtraction {
    private BinaryOperation subtraction;

    public void setSubtraction (Double left, Double right) {
        subtraction = new com.reference.calc.expression.operation.Subtraction(new HelperDoubleExpression(left), new HelperDoubleExpression(right));
    }

    @Test
    public void minuendBiggerThanSubtrahend () {
        Double expected = 3.0-2.0;
        setSubtraction(3.0, 2.0);
        Double actual = subtraction.evaluate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minuendSmallerThanSubtrahend () {
        Double expected = 2.0-3.0;
        setSubtraction(2.0, 3.0);
        Double actual = subtraction.evaluate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minuendEqualToSubtrahend () {
        Double expected = 3.0-3.0;
        setSubtraction(3.0, 3.0);
        Double actual = subtraction.evaluate();
        Assert.assertEquals(expected, actual);
    }
}
