package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private String[] values;
    private final Queue<String> InputDataQueue = new LinkedList<>();

    @BeforeEach
    void setUp() {
        values =  "23 + 3 * 4 / 2".split(" ");
        Collections.addAll(InputDataQueue, values);
    }

    @Test
    @DisplayName("입력값 split & 큐 데이터 검증 테스트")
    void splitInputAndAddAllQueue() {
        assertThat(values[0]).isEqualTo("23");
    }

    @Test
    @DisplayName("연산 기호 검증 테스트")
    void validateExpression() {
        MathExpression ret = validateExpression("+");
        assertThat(ret).isEqualTo(MathExpression.PLUS);
    }

    @Test
    @DisplayName("부적절한 연산기호 예외처리 테스트")
    void validateIllegalArgExpression() {
        assertThatThrownBy(() -> {
            validateExpression("%");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산기호 케이스 별로 연산 검증 테스트")
    void calculateByCaseTest() {
        int sum = 30;
        String poll = "4";
        sum = calculateByCase(sum, poll, MathExpression.PLUS);
        assertThat(sum).isEqualTo(34);
    }

    @Test
    @DisplayName("부적절한 문자열 입력시 예외처리 테스트")
    void calculateByCaseIllegalArg() {
        assertThatThrownBy(() -> {
            calculateByCase(30,"Illegal",MathExpression.PLUS);
        }).isInstanceOf(IllegalArgumentException.class);
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


