package study;

import java.util.Queue;

public class StringCalculator extends Calculator {
    Queue<String> InputDataQueue;

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

    public StringCalculator(int sum, Queue<String> InputDataQueue) {
        super(sum);
        this.InputDataQueue = InputDataQueue;
    }

    public int calculateSum(Queue<String> InputDataQueue) {
        while (!InputDataQueue.isEmpty()) {
            MathExpression mathExpression = validateExpression(InputDataQueue.poll());
            assert mathExpression != null;
            sum = calculateByCase(sum, InputDataQueue.poll(), mathExpression);
        }
        return sum;
    }

    private MathExpression validateExpression(String expression) throws IllegalArgumentException {
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
        throw new IllegalArgumentException();
    }

    private int calculateByCase(int sum, String poll, MathExpression mathExpression) throws IllegalArgumentException {
        if (mathExpression.equals(MathExpression.PLUS)) {
            return sum += Integer.parseInt(poll);
        } else if (mathExpression.equals(MathExpression.MINUS)) {
            return sum -= Integer.parseInt(poll);
        } else if (mathExpression.equals(MathExpression.MULTI)) {
            return sum *= Integer.parseInt(poll);
        } else if (mathExpression.equals(MathExpression.DIVIDE)) {
            return sum /= Integer.parseInt(poll);
        }
        throw new IllegalArgumentException();
    }
}
