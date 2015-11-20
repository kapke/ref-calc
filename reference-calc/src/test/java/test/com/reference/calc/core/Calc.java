package test.com.reference.calc.core;

import com.reference.calc.operation.Addition;
import com.reference.calc.operation.Operation;
import com.reference.calc.operation.Subtraction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kapke on 24.02.15.
 */
public class Calc {
    private com.reference.calc.Calc calc;

    @Before
    public void setUp () {
        this.calc = new com.reference.calc.Calc();
        this.calc.registerOperation(new Addition());
        this.calc.registerOperation(new Subtraction());
    }

    @Test
    public void itShouldReturnNullIfOperationIsNotRegistered () {
        Assert.assertEquals(this.calc.calculate(1.0, "a", 2.0), null);
    }

    @Test
    public void itShouldUseProperOperationIfPossible () {
        Double sum = this.calc.calculate(1.0, "+", 1.0);

        Assert.assertEquals(2.0, sum, 0.01);
    }

    @Test
    public void itShouldBeAbleToEvaluateExpression () {
        Double sum = this.calc.calculate("1.0 + 1.0");

        Assert.assertEquals(2.0, sum, 0.01);
    }

    @Test
    public void itShouldBeAbleToEvaluateExpressionWithNegativeNumbers () {
        Double sum1 = calc.calculate("-1 + 2");
        Double sum2 = calc.calculate("1 + -2");
        Double sum3 = calc.calculate("1 + (-2)");

        Assert.assertEquals(1.0, sum1, 0);
        Assert.assertEquals(-1.0, sum2, 0);
        Assert.assertEquals(-1, sum3, 0);
    }
}
