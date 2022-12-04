package junit5.topics.asserts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardAssertionsTest {

    @Test
    void standardAssertions() {
        assertEquals(2, 2, "Assert error mess");
        assertTrue(true, "The optional assertion message is now the last parameter");

        assertFalse(isUserBalancePos(), () -> "Really " + "expensive " + "message" + ".");
    }

    public boolean isUserBalancePos(){
        //logic
        return true;
    }

    public boolean isUserBalancePos(int a){
        //logic
        return true;
    }

    public boolean isUserBalancePos(Object a, Object b){
        //logic
        return a.equals(b);
    }

}
