package insight.clac.expression;

public class MultiplyExpression extends BinaryOperatorExpression {

    protected MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int value() {
        return left.value() * right.value();
    }
}