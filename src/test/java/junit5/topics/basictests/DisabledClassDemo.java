package junit5.topics.basictests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }

    @Test
    void test1() {
    	System.out.println("test 1");
    }
    
    @Test
    void test2() {
    	System.out.println("test 2");
    }
    
    @Test
    void test3() {
    	System.out.println("test 2");
    }
}
