package study;

public abstract class Calculator {
    int sum;

    public Calculator(int sum) {
        this.sum = sum;
    }

    abstract int plus(int sum, int input);
    abstract int minus(int sum, int input);
    abstract int multi(int sum, int input);
    abstract int divide(int sum, int input);
}
