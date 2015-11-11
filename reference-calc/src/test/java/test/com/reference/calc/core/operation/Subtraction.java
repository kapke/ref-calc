package test.com.reference.calc.core.operation;

import com.reference.calc.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kapke on 11.11.15.
 */
public class Subtraction {
    private Operation subtraction;

    @Before
    public void setUp () {
        subtraction = new com.reference.calc.operation.Subtraction();
    }

    @Test
    public void minuendBiggerThanSubtrahend () {
        Double expected = 3.0-2.0;
        Double actual = subtraction.calc(3, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minuendSmallerThanSubtrahend () {
        Double expected = 2.0-3.0;
        Double actual = subtraction.calc(2, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minuendEqualToSubtrahend () {
        Double expected = 3.0-3.0;
        Double actual = subtraction.calc(3, 3);
        Assert.assertEquals(expected, actual);
    }
}
