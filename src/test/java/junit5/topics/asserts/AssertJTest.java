package junit5.topics.asserts;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    void test() {
        System.out.println("Assertions using AssertJ");

        int sum = 1 + 1;

        assertThat(sum).isEqualTo(2);
        assertThat(sum).isGreaterThan(1).isLessThan(3);

        System.out.println("Pass");
    }
}
