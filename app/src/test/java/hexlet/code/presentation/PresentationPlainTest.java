package hexlet.code.presentation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.TreeMap;

import hexlet.code.Difference;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PresentationPlainTest {

    private static final Map<String, Difference> TEST_MAP = new TreeMap<>();
    private static final String EXPECTED_DATA = "Property 'follow' was removed\n"
            + "Property 'host' was unchanged\n"
            + "Property 'proxy' was removed\n"
            + "Property 'timeout' was updated. From '50' to '20'\n"
            + "Property 'verbose' was added with value: true\n";

    @BeforeAll
    static void init() {
        TEST_MAP.put("follow", new Difference("removed", false));
        TEST_MAP.put("verbose", new Difference("added", true));
        TEST_MAP.put("host", new Difference("unchanged", "hexlet.io"));
        TEST_MAP.put("proxy", new Difference("removed", "123.234.53.22"));
        TEST_MAP.put("timeout", new Difference("update", 50, 20));
    }

    @Test
    void defaultPlainTest() {
        String actual = new PresentationPlain().presentation(TEST_MAP);
        assertEquals(EXPECTED_DATA, actual);
    }

    @Test
    void emptyPlainTest() {
        String actual = new PresentationPlain().presentation(new TreeMap<>());
        String expected = "{}";
        assertEquals(expected, actual);
    }

}
