package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] arr = "1,2".split(",");
        assertThat(arr).containsExactly("1","2");
    }

    @Test
    void splitOneElementCase() {
        String[] arr = "1".split(",");
        assertThat(arr).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

}
