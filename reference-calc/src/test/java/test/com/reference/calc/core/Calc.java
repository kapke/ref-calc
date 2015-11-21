package test.com.reference.calc.core;

import com.reference.calc.exception.CalcException;
import com.reference.calc.operation.Addition;
import com.reference.calc.operation.Subtraction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void itShouldEvaluateExpression () throws CalcException {
        Double sum = this.calc.calculate("1.0 + 1.0");

        Assert.assertEquals(2.0, sum, 0.01);
    }

    @Test
    public void itShouldEvaluateExpressionWithNegativeNumbers () throws CalcException {
        Double sum1 = calc.calculate("-1 + 2");
        Double sum2 = calc.calculate("1 + -2");
        Double sum3 = calc.calculate("1 + (-2)");

        Assert.assertEquals(1.0, sum1, 0);
        Assert.assertEquals(-1.0, sum2, 0);
        Assert.assertEquals(-1, sum3, 0);
    }

    @Test
    public void itShouldEvaluateComplexExpressionsWithRightOrderOfExecution () throws CalcException {
        Double result = calc.calculate("2 + 2 * 2");

        Assert.assertEquals(6, result, 0);
    }

    @Test
    public void itShouldEvaluateExpressionsWithGroupingInParentheses () throws CalcException {
        Double result1 = calc.calculate("(2 + 2) * 2");
        Double result2 = calc.calculate("(2 + 2) * (3 + 4)");

        Assert.assertEquals(8, result1, 0);
        Assert.assertEquals(28, result2, 0);
    }

    @Test
    public void itShouldCalculateExpressionsWithNestedParentheses () throws CalcException {
        Double result1 = calc.calculate("(1 + (2 * 3)) * 2");

        Assert.assertEquals(14, result1, 0);
    }

    @Test
    public void itShouldEvaluateExpressionWhichIsWholeGroupedInParentheses () throws CalcException {
        Double result1 = calc.calculate("(1 + 2)");
        Double result2 = calc.calculate("(2 + 2 * 2)");

        Assert.assertEquals(3, result1, 0);
        Assert.assertEquals(6, result2, 0);
    }

    @Test
    public void itShouldBeSpaceInsensitive () throws CalcException {
        Double[] results = {
            calc.calculate("1+2"),
            calc.calculate("1+ 2"),
            calc.calculate("1 + 2"),
            calc.calculate(" 1 +   2")
        };

        for (Double result : results) {
            Assert.assertEquals(3, result, 0);
        }
    }
}
