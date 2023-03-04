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
        StringCalculator stringCalculator = new StringCalculator(sum, queue);
        System.out.println(stringCalculator.calculateSum(queue));
    }
}
