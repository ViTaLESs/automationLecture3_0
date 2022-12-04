package junit5.topics.asserts;

import junit5.topics.asserts.resources.MySUT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionTest {

    MySUT mySut;

    @BeforeEach
    void setup() {
        mySut = new MySUT("[Assertions test]");
    }

    @Test
    void exceptionTesting() {
        System.out.println("Testing with assertThrows");
        assertThrows(RuntimeException.class, mySut::releaseId);
        System.out.println("End of test");
    }
}
