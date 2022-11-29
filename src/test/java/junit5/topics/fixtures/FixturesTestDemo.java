package junit5.topics.fixtures;

import org.junit.jupiter.api.*;

class FixturesTestDemo {

    @BeforeAll
    static void setupAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void setup() {
        System.out.println("@BeforeEach");
    }

    @Test
    void test1() {
        System.out.println("@Test [1]");
    }

    @Test
    void test2() {
        System.out.println("@Test [2]");
    }

    @AfterEach
    void teardown() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void teardownAll() {
        System.out.println("@AfterAll");
    }
}
