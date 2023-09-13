package hexlet.code.formatters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.TreeMap;

import hexlet.code.Difference;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatStylishTest {

    private static final Map<String, Difference> TEST_MAP = new TreeMap<>();
    private static final String EXPECTED_DATA = "{\n"
            + "  - follow: false\n"
            + "    host: hexlet.io\n"
            + "  - proxy: 123.234.53.22\n"
            + "  - timeout: 50\n"
            + "  + timeout: 20\n"
            + "  + verbose: true\n"
            + "}";

    @BeforeAll
    static void init() {
        TEST_MAP.put("follow", new Difference("removed", false));
        TEST_MAP.put("verbose", new Difference("added", true));
        TEST_MAP.put("host", new Difference("unchanged", "hexlet.io"));
        TEST_MAP.put("proxy", new Difference("removed", "123.234.53.22"));
        TEST_MAP.put("timeout", new Difference("update", 50, 20));
    }

    @Test
    void defaultStylishTest() {
        String actual = new FormatStylish().presentation(TEST_MAP);
        assertEquals(EXPECTED_DATA, actual);
    }

    @Test
    void emptyStylishTest() {
        String actual = new FormatStylish().presentation(new TreeMap<>());
        String expected = "{}";
        assertEquals(expected, actual);
    }

}
