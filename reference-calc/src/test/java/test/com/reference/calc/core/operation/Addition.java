package test.com.reference.calc.core.operation;

import com.reference.calc.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kapke on 24.02.15.
 */
public class Addition {
    private Operation addition;

    private Operation getAddition () {
        return new com.reference.calc.operation.Addition();
    }

    @Before
    public void setUp () {
        addition = getAddition();
    }

    @Test
    public void twoPositives () {
        Double expected = 1.0+2.0;
        Double actual = addition.calc(1, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leftZero () {
        Double expected = 1.0;
        Double actual = addition.calc(0, 1.0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightZero () {
        Double expected = 1.0;
        Double actual = addition.calc(1.0, 0);
        Assert.assertEquals(expected, actual);
    }
}
