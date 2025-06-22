package insight;

import insight.clac.expression.Expression;
import insight.clac.expression.ExpressionParser;

public class Main {
    public static void main(String[] args) {
       //   1+15*(9+4+(1+5)) + 6
        ExpressionParser parser = new ExpressionParser("1 + 15 * (9 + 4 + (1 + 5)) + 6");
        Expression parse = parser.parse();
        System.out.println("计算结果: " + parse.value()); // 输出计算结果


    }



}