package junit5.topics.asserts;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class HamcrestTest {

    @Test
    void assertWithHamcrestMatcher() {
        assertThat(2 + 1, equalTo(4));
        assertThat("Foo", notNullValue());
        assertThat("Hello world", containsString("world"));
    }
}
