package study;

import java.util.Queue;

public class StringCalculator extends Calculator {
    private Queue<String> queue;

    @Override
    public int plus(int sum, int input) {
        return sum + input;
    }

    @Override
    public int minus(int sum, int input) {
        return sum + input;
    }

    @Override
    public int multi(int sum, int input) {
        return sum + input;
    }

    @Override
    public int divide(int sum, int input) {
        return sum + input;
    }

    public StringCalculator(int sum, Queue<String> queue) {
        super(sum);
        this.queue = queue;
    }

    public int calculateSum(Queue<String> queue) {
        while (!queue.isEmpty()) {
            MathExpression mathExpression = validateExpression(queue.poll());
            assert mathExpression != null;
            sum = calculateByCase(sum, queue.poll(), mathExpression);
        }
        return sum;
    }
    private MathExpression validateExpression(String expression) {
        switch (expression) {
            case "+":
                return MathExpression.PLUS;
            case "-":
                return MathExpression.MINUS;
            case "*":
                return MathExpression.MULTI;
            case "/":
                return MathExpression.DIVIDE;
        }
        return null;
    }
    private int calculateByCase(int sum, String poll, MathExpression mathExpression) {
        if(mathExpression.equals(MathExpression.PLUS)) {
            sum+=Integer.parseInt(poll);
        } else if (mathExpression.equals(MathExpression.MINUS)) {
            sum-=Integer.parseInt(poll);
        } else if (mathExpression.equals(MathExpression.MULTI)) {
            sum*=Integer.parseInt(poll);
        } else if (mathExpression.equals(MathExpression.DIVIDE)) {
            sum/=Integer.parseInt(poll);
        }
        return sum;
    }
}
