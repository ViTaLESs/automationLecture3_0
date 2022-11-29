package junit5.topics.asserts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardAssertionsTest {

    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertTrue(true,
                "The optional assertion message is now the last parameter");
        assertFalse(false, () -> "Really " + "expensive " + "message" + ".");
    }

}
