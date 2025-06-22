package insight.clac.expression;

public class DevisionExpression extends BinaryOperatorExpression {

    protected DevisionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int value() {
        if (right.value() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left.value() / right.value();
    }
}