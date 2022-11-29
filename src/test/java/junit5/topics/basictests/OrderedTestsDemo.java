package junit5.topics.basictests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class OrderedTestsDemo {
/*
    MethodOrderer.DisplayName: sorts test methods alphanumerically based on their display names (see display name generation precedence rules)

    MethodOrderer.MethodName: sorts test methods alphanumerically based on their names and formal parameter lists

    MethodOrderer.OrderAnnotation: sorts test methods numerically based on values specified via the @Order annotation

    MethodOrderer.Random: orders test methods pseudo-randomly and supports configuration of a custom seed

    MethodOrderer.Alphanumeric: sorts test methods alphanumerically based on their names and formal parameter lists; deprecated in favor of MethodOrderer.MethodName, to be removed in 6.0
    */
    @Test
    //@Order(1)
    void nullValues() {
        // perform assertions against null values
    }

    @Test
    //@Order(2)
    void emptyValues() {
        // perform assertions against empty values
    }

    @Test
    //@Order(3)
    void validValues() {
        // perform assertions against valid values
    }
}
