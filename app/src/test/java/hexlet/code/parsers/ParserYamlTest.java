package hexlet.code.parsers;

import hexlet.code.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserYamlTest {

    private static final byte[] EMPTY_FILE = new byte[0];
    private static final String FILE_1 = "src/test/resources/file1.yml";
    private static final Map<String, Object> EXPECTED_DATA = new HashMap<>();
    private static final Object VALUE_1 = 200;
    private static final Object VALUE_2 = List.of(1, 2, 3, 4);
    private static final Object VALUE_3 = List.of(2, 3, 4, 5);
    private static final Object VALUE_4 = 45;
    private static final Object VALUE_5 = List.of(3, 4, 5);

    @BeforeAll
    static void init() {
        EXPECTED_DATA.put("setting1", "Some value");
        EXPECTED_DATA.put("setting2", VALUE_1);
        EXPECTED_DATA.put("setting3", true);
        EXPECTED_DATA.put("key1", "value1");
        EXPECTED_DATA.put("numbers1", VALUE_2);
        EXPECTED_DATA.put("numbers2", VALUE_3);
        EXPECTED_DATA.put("id", VALUE_4);
        EXPECTED_DATA.put("default", null);
        EXPECTED_DATA.put("checked", false);
        EXPECTED_DATA.put("numbers3", VALUE_5);
        EXPECTED_DATA.put("chars1", List.of("a", "b", "c"));
        EXPECTED_DATA.put("chars2", List.of("d", "e", "f"));
    }

    @Test
    void defaultTest() throws IOException {
        var actual = new ParserYaml().parse(FileUtils.readFile(FILE_1));
        assertEquals(EXPECTED_DATA.size(), actual.size());

        for (var entry : actual.entrySet()) {
            assertEquals(EXPECTED_DATA.get(entry.getKey()), entry.getValue());
        }
    }

    @Test
    void emptyFileTest() throws IOException {
        var actual = new ParserYaml().parse(EMPTY_FILE);
        var expected = new HashMap<>();
        assertEquals(expected, actual);
    }

}
