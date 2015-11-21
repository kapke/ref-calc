package test.com.reference.calc.core.expression.operation;

import com.reference.calc.expression.operation.BinaryOperation;
import org.junit.Assert;
import org.junit.Test;
import test.com.reference.calc.core.helpers.HelperDoubleExpression;

/**
 * Created by kapke on 24.02.15.
 */
public class Addition {
    private BinaryOperation addition;

    private void setAddition (Double left, Double right) {
        addition = new com.reference.calc.expression.operation.Addition(new HelperDoubleExpression(left), new HelperDoubleExpression(right));
    }

    @Test
    public void twoPositives () {
        Double expected = 1.0+2.0;
        setAddition(1.0, 2.0);
        Double actual = addition.evaluate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leftZero () {
        Double expected = 1.0;
        setAddition(0.0, 1.0);
        Double actual = addition.evaluate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightZero () {
        Double expected = 1.0;
        setAddition(1.0, 0.0);
        Double actual = addition.evaluate();
        Assert.assertEquals(expected, actual);
    }
}
