package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FindingDifferencesTest {

    private static Map<String, Map<String, Object>> expecteds = new HashMap<>();
    private static Map<String, Object> first = Map.of(
            "host", "hexlet.io",
            "timeout", 50,
            "proxy", "123.234.53.22",
            "follow", false);

    private static Map<String, Object> second = Map.of(
            "timeout", 20,
            "verbose", true,
            "host", "hexlet.io");

    @BeforeAll
    static void init() {
        expecteds.put("follow", Map.of("-", false));
        expecteds.put("verbose", Map.of("+", true));
        expecteds.put("host", Map.of(" ", "hexlet.io"));
        expecteds.put("proxy", Map.of("-", "123.234.53.22"));
        expecteds.put("timeout", Map.of("+", 20, "-", 50));
    }

    @Test
    void defaultTest() {
        var result = FindingDifferences.search(first, second);

        assertEquals(result.size(), expecteds.size());

        for (var entry : result.entrySet()) {
            assertEquals(expecteds.get(entry.getKey()), result.get(entry.getKey()));
        }
    }

    @Test
    void emptyTest() {
        Map<String, Map<String, Object>> emptyMap = new HashMap<>();
        var result = FindingDifferences.search(new HashMap<>(), new HashMap<>());

        assertEquals(result, emptyMap);
    }

}
