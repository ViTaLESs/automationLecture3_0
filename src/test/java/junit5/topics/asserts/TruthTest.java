package junit5.topics.asserts;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class TruthTest {

    final Logger log = getLogger(lookup().lookupClass());

    @Test
    void test() {
        log.debug("Assertion using Truth");

        int sum = 1 + 1;

        assertThat(sum).isEqualTo(2);
    }

}
