package insight.clac.expression;

public class AddExpression extends BinaryOperatorExpression{

    protected AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int value() {
        return left.value() + right.value();
    }
}