package junit5.topics.basictests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

//TODO: uncomment pom -> surefire-plugin
@Tag("regression")
public class TagsDemo {

    @Test
    @Tag("acceptance")
    @Tag("integration")
    void testMethod1() {
        System.out.println("Pass");
        assertEquals(2 + 2, 4);
    }

    @Test
    @Tag("unitTest")
    void testMethod2() {
        System.out.println("unitTest");
        assertEquals(2 + 2, 4);
    }
}
