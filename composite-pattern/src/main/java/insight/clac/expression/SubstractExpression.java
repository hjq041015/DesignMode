package insight.clac.expression;

public class SubstractExpression extends BinaryOperatorExpression{
    protected SubstractExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int value() {
        return left.value() - right.value();
    }
}