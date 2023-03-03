package study;

import java.util.*;

public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, values);

        int sum = Integer.parseInt(Objects.requireNonNull(queue.poll()));
        Calculator calculator = new Calculator();
        while(!queue.isEmpty()) {
            switch (queue.poll()) {
                case "+":
                    sum = calculator.plus(sum, Integer.parseInt(Objects.requireNonNull(queue.poll())));
                    break;
                case "-":
                    sum = calculator.minus(sum, Integer.parseInt(Objects.requireNonNull(queue.poll())));
                    break;
                case "*":
                    sum = calculator.multiple(sum, Integer.parseInt(Objects.requireNonNull(queue.poll())));
                    break;
                case "/":
                    sum = calculator.divide(sum, Integer.parseInt(Objects.requireNonNull(queue.poll())));
                    break;
            }
        }
        System.out.println(sum);
    }
}
