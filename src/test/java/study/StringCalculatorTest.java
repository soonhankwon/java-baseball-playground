package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private String[] values;

    @BeforeEach
    void setUp() {
        values =  "23 + 3 * 4 / 2".split(" ");
    }

    @Test
    @DisplayName("입력값 split 검증 테스트")
    void splitInput() {
        Assertions.assertThat(values[0]).isEqualTo("23");
    }

    @Test
    @DisplayName("String 숫자로 변환 후 연산 테스트")
    void convertStringToIntegerAndCalculate() {
        int sum = 0;
        for(String element : values) {

        }
    }
}
