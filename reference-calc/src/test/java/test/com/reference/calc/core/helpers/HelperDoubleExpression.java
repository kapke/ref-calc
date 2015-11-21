package test.com.reference.calc.core.helpers;

import com.reference.calc.expression.Expression;

/**
 * Created by kapke on 21.11.15.
 */
public class HelperDoubleExpression extends Expression {
    private final Double value;

    public HelperDoubleExpression (Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate() {
        return value;
    }
}
