package test.com.reference.calc.core.operation;

import com.reference.calc.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kapke on 11.11.15.
 */
public class Division {
    private Operation division;

    @Before
    public void setUp () {
        division = new com.reference.calc.operation.Division();
    }

    @Test
    public void integerDivision () {
        Double expected = 2.0;
        Double actual = division.calc(6, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dividendEqualToZero () {
        Double expected = 0.0;
        Double actual = division.calc(0, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void divisorEqualToZero () {
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = division.calc(2, 0);
        Assert.assertEquals(expected, actual);

        expected = Double.NEGATIVE_INFINITY;
        actual = division.calc(-2, 0);
        Assert.assertEquals(expected, actual);
    }
}
