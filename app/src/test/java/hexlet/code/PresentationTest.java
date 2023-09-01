package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

class PresentationTest {

    private static Map<String, Map<String, Object>> testMap = new TreeMap<>();

    @BeforeAll
    static void init() {
        Map<String, Object> prefixAndValue = new TreeMap<>(Comparator.reverseOrder());
        prefixAndValue.putAll(Map.of("+", 20, "-", 50));
        testMap.putAll(Map.of(
                "follow", Map.of("-", false),
                "verbose", Map.of("+", true),
                "host", Map.of(" ", "hexlet.io"),
                "proxy", Map.of("-", "123.234.53.22")));
        testMap.put("timeout", prefixAndValue);
    }

    @Test
    void defaultPlainTextTest() {
        var result = Presentation.plainTextPresentation(testMap);
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}\n";
        assertEquals(expected, result);
    }

    @Test
    void emptyPlainTextTest() {
        var result = Presentation.plainTextPresentation(new TreeMap<>());
        String expected = "{}";
        assertEquals(expected, result);
    }

}
