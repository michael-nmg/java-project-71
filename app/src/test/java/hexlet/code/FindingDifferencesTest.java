package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindingDifferencesTest {

    private static Map<String, Object> first = Map.of(
            "host", "hexlet.io",
            "timeout", 50,
            "proxy", "123.234.53.22",
            "follow", false);

    private static Map<String, Object> second = Map.of(
            "timeout", 20,
            "verbose", true,
            "host", "hexlet.io");

    @Test
    void defaultTest() {
        var result = FindingDifferences.search(first, second);
        assertThat(result)
                .hasSize(5)
                .containsEntry("follow", Map.of("-", false))
                .containsEntry("verbose", Map.of("+", true))
                .containsEntry("host", Map.of(" ",  "hexlet.io"))
                .containsEntry("proxy", Map.of("-", "123.234.53.22"))
                .containsEntry("timeout", Map.of("+", 20, "-", 50));
    }

    @Test
    void emptyTest() {
        Map<String, Map<String, Object>> emptyMap = new HashMap<>();
        var result = FindingDifferences.search(new HashMap<>(), new HashMap<>());

        assertEquals(result, emptyMap);
    }

}
