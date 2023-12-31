package hexlet.code.formatters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;

import hexlet.code.Difference;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatPlainTest {

    private static final Object VALUE_1 = 50;
    private static final Object VALUE_2 = 20;
    private static final Object VALUE_3 = List.of(1, 2, 3, 4, 5);
    private static final Map<String, Difference> TEST_MAP = new TreeMap<>();
    private static final String EXPECTED_DATA = "Property 'follow' was removed\n"
            + "Property 'host2' was added with value: 'yandex.ru'\n"
            + "Property 'numbers' was added with value: [complex value]\n"
            + "Property 'proxy' was removed\n"
            + "Property 'timeout' was updated. From 50 to 20\n"
            + "Property 'vector' was added with value: null\n"
            + "Property 'verbose' was added with value: true";

    @BeforeAll
    static void init() {
        TEST_MAP.put("follow", new Difference("removed", false));
        TEST_MAP.put("verbose", new Difference("added", true));
        TEST_MAP.put("host1", new Difference("unchanged", "hexlet.io"));
        TEST_MAP.put("host2", new Difference("added", "yandex.ru"));
        TEST_MAP.put("proxy", new Difference("removed", "123.234.53.22"));
        TEST_MAP.put("timeout", new Difference("updated", VALUE_1, VALUE_2));
        TEST_MAP.put("numbers", new Difference("added", VALUE_3));
        TEST_MAP.put("vector", new Difference("added", null));
    }

    @Test
    void defaultPlainTest() {
        String actual = new FormatPlain().presentation(TEST_MAP);
        assertEquals(EXPECTED_DATA, actual);
    }

    @Test
    void emptyPlainTest() {
        String actual = new FormatPlain().presentation(new TreeMap<>());
        assertTrue(actual.isEmpty());
    }

}
