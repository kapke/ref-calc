package test.com.reference.calc.core.operation;

import com.reference.calc.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DoubleHolder;

/**
 * Created by kapke on 11.11.15.
 */
public class Multiplication {
    private Operation multiplication;

    @Before
    public void setUp () {
        multiplication = new com.reference.calc.operation.Multiplication();
    }

    @Test
    public void positiveFactors () {
        Double expected = 6.0;
        Double actual1 = multiplication.calc(2.0, 3.0);
        Double actual2 = multiplication.calc(3.0, 2.0);
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void factorEqualToZero () {
        Double expected = 0.0;
        Double actual1 = multiplication.calc(0, 2.0);
        Double actual2 = multiplication.calc(2.0, 0);
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void negativeFactor () {
        Double expected = -6.0;
        Double actual1 = multiplication.calc(-2, 3);
        Double actual2 = multiplication.calc(2, -3);
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void negativeFactors () {
        Double expected = 6.0;
        Double actual = multiplication.calc(-2, -3);
        Assert.assertEquals(expected, actual);
    }
}
