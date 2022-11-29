package junit5.topics.basictests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class FirstJUnit5Tests {

    @Test
    //@RepeatedTest(5)
    void myFirstTest() {
        System.out.println("Hello word!");
        assertEquals(2, 1 + 1);
    }
}
