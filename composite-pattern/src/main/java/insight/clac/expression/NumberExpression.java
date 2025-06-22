package insight.clac.expression;

public class NumberExpression implements Expression{

    private final int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return this.value;
    }
}