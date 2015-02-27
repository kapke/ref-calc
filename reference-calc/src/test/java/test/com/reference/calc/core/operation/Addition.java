package test.com.reference.calc.core.operation;

import com.reference.calc.operation.Operation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kapke on 24.02.15.
 */
public class Addition {
    private Operation getAddition () {
        return new com.reference.calc.operation.Addition();
    }

    @Test
    public void twoPositives () {
        Operation addition = this.getAddition();
        Double expected = 1.0+2.0;
        Double actual = addition.calc(1, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leftZero () {
        Operation addition = this.getAddition();
        Double expected = 1.0;
        Double actual = addition.calc(0, 1.0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightZero () {
        Operation addition = this.getAddition();
        Double expected = 1.0;
        Double actual = addition.calc(1.0, 0);
        Assert.assertEquals(expected, actual);
    }
}
