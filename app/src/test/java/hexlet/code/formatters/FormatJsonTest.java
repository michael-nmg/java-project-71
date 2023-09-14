package hexlet.code.formatters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;

import hexlet.code.Difference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatJsonTest {

    private static final Object VALUE_1 = 50;
    private static final Object VALUE_2 = 20;
    private static final Object VALUE_3 = List.of(1, 2, 3, 4, 5);
    private static final Map<String, Difference> TEST_MAP = new TreeMap<>();
    private static final String EXPECTED_DATA = "[{\"name\":\"follow\",\"status\":\"removed\",\"value\":false},"
            + "{\"name\":\"host1\",\"status\":\"unchanged\",\"value\":\"hexlet.io\"},"
            + "{\"name\":\"host2\",\"status\":\"added\",\"value\":\"yandex.ru\"},"
            + "{\"name\":\"numbers\",\"status\":\"added\",\"value\":[1,2,3,4,5]},"
            + "{\"name\":\"proxy\",\"status\":\"removed\",\"value\":\"123.234.53.22\"},"
            + "{\"name\":\"timeout\",\"status\":\"updated\",\"value1\":50,\"value2\":20},"
            + "{\"name\":\"verbose\",\"status\":\"added\",\"value\":true}]";

    @BeforeAll
    static void init() {
        TEST_MAP.put("follow", new Difference("removed", false));
        TEST_MAP.put("verbose", new Difference("added", true));
        TEST_MAP.put("host1", new Difference("unchanged", "hexlet.io"));
        TEST_MAP.put("host2", new Difference("added", "yandex.ru"));
        TEST_MAP.put("proxy", new Difference("removed", "123.234.53.22"));
        TEST_MAP.put("timeout", new Difference("updated", VALUE_1, VALUE_2));
        TEST_MAP.put("numbers", new Difference("added", VALUE_3));
    }

    @Test
    void defaultJsonTest() throws Exception {
        String actual = new FormatJson().presentation(TEST_MAP);
        assertEquals(EXPECTED_DATA, actual);
    }

    @Test
    void emptyJsonTest() throws Exception {
        String actual = new FormatJson().presentation(new TreeMap<>());
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    void throwUnsupportedStatusJsonTest() {
        Map<String, Difference> testMap = Map.of("key", new Difference("unsupported", 0, null));
        assertThrows(RuntimeException.class, () -> new FormatJson().presentation(testMap));
    }

}
