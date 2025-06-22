package insight.clac.expression;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExpressionParser {

    private final String infixExpression; // 中缀表达式
    int point = 0; // 当前解析位置

    public ExpressionParser(String infixExpression) {
        this.infixExpression = infixExpression; // 初始化中缀表达式
    }

    // 将中缀表达式转换为后缀表达式
    public List<String> toSuffix(String infixExpression) {
        List<String> suffix = new ArrayList<>(); // 存储后缀表达式
        LinkedList<String> stack = new LinkedList<>(); // 运算符栈
        int point = 0;

        while (point < infixExpression.length()) {
            char c = infixExpression.charAt(point); // 当前字符

            if (c == ' ') { // 跳过空格
                point++;
                continue;
            }

            if (c == '(') { // 左括号直接入栈
                stack.addLast("(");
            } else if (c == ')') { 
                // 遇到右括号，弹出栈中运算符直到左括号
                while (!stack.isEmpty() && !stack.getLast().equals("(")) {
                    suffix.add(stack.removeLast());
                }
                if (!stack.isEmpty() && stack.getLast().equals("(")) {
                    stack.removeLast(); // 移除左括号
                } else {
                    throw new IllegalArgumentException("括号不匹配"); // 抛出异常，括号不匹配
                }
            } else if (c == '*' || c == '/') { 
                // 处理乘除运算符，弹出栈中优先级不低于当前运算符的运算符
                while (!stack.isEmpty() && (stack.getLast().equals("*") || stack.getLast().equals("/"))) {
                    suffix.add(stack.removeLast());
                }
                stack.addLast(c + ""); // 当前运算符入栈
            } else if (c == '+' || c == '-') { 
                // 处理加减运算符，弹出栈中所有运算符
                while (topIsOperator(stack)) {
                    suffix.add(stack.removeLast());
                }
                stack.addLast(c + ""); // 当前运算符入栈
            } else if (Character.isDigit(c)) { 
                // 处理数字，读取完整的数字
                StringBuilder builder = new StringBuilder();
                while (point < infixExpression.length() && Character.isDigit(infixExpression.charAt(point))) {
                    builder.append(infixExpression.charAt(point));
                    point++;
                }
                point--; // 回退一位，因为多读取了一位
                suffix.add(builder.toString()); // 将数字加入后缀表达式
            } else {
                throw new IllegalArgumentException("不支持的字符: " + c); // 抛出异常，遇到不支持的字符
            }

            point++; // 移动到下一个字符
        }

        // 将栈中剩余的运算符加入后缀表达式
        while (!stack.isEmpty()) {
            suffix.add(stack.removeLast());
        }

        return suffix; // 返回后缀表达式
    }

    // 解析后缀表达式并构建表达式树
    public Expression parse() {
        List<String> suffix = toSuffix(infixExpression); // 将中缀表达式转换为后缀表达式
        LinkedList<Expression> stack = new LinkedList<>(); // 表达式栈，用于构建表达式树

        for (String item : suffix) {
            if (item.equals("+")) {
                // 遇到加号，弹出两个操作数并构建加法表达式
                Expression right = stack.removeLast();
                stack.addLast(new AddExpression(stack.removeLast(), right));
            } else if (item.equals("-")) {
                // 遇到减号，弹出两个操作数并构建减法表达式
                Expression right = stack.removeLast();
                stack.addLast(new SubstractExpression(stack.removeLast(), right));
            } else if (item.equals("*")) {
                // 遇到乘号，弹出两个操作数并构建乘法表达式
                Expression right = stack.removeLast();
                stack.addLast(new MultiplyExpression(stack.removeLast(), right));
            } else if (item.equals("/")) {
                // 遇到除号，弹出两个操作数并构建除法表达式
                Expression right = stack.removeLast();
                stack.addLast(new DevisionExpression(right, stack.removeLast()));
            } else {
                // 遇到数字，直接构建数字表达式并入栈
                int value = Integer.parseInt(item);
                stack.addLast(new NumberExpression(value));
            }
        }

        return stack.removeLast(); // 返回栈顶元素，即最终的表达式树
    }

    // 判断栈顶是否是运算符
    private boolean topIsOperator(LinkedList<String> stack) {
        if (stack.isEmpty()) return false; // 栈为空时返回 false
        String top = stack.getLast(); // 获取栈顶元素
        return top.equals("+") || top.equals("-") || top.equals("*") || top.equals("/"); // 判断是否为运算符
    }
}