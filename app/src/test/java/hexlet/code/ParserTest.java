package hexlet.code;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    private static Map<String, Object> expecteds = new HashMap<>();
    private static final String FILE_PATH_YML = "src/test/resources/file1.yml";
    private static final String FILE_PATH_JSON = "src/test/resources/file1.json";
    private static final String EMPTY_FILE_PATH_YML = "src/test/resources/emptyfile.yml";
    private static final String EMPTY_FILE_PATH_JSON = "src/test/resources/emptyfile.json";
    private static final String FILE_WITHOUT_EXTENSION = "src/test/resources/emptyfile";

    @BeforeAll
    static void init() {
        expecteds.put("host", "hexlet.io");
        expecteds.put("timeout", 50);
        expecteds.put("proxy", "123.234.53.22");
        expecteds.put("follow", false);
    }

    @Test
    void testParseJson() throws IOException {
        Map<String, Object> result = Parser.parse(FILE_PATH_JSON);

        for (var entry : result.entrySet()) {
            assertEquals(expecteds.get(entry.getKey()), result.get(entry.getKey()));
        }
    }

    @Test
    void testParseYml() throws IOException {
        Map<String, Object> result = Parser.parse(FILE_PATH_YML);

        for (var entry : result.entrySet()) {
            assertEquals(expecteds.get(entry.getKey()), result.get(entry.getKey()));
        }
    }

    @Test
    void testEmptyJson() throws IOException {
        assertThrows(MismatchedInputException.class, () -> Parser.parse(EMPTY_FILE_PATH_JSON));
    }

    @Test
    void testEmptyYml() throws IOException {
        assertThrows(MismatchedInputException.class, () -> Parser.parse(EMPTY_FILE_PATH_YML));
    }

    @Test
    void testNotExtension() throws IOException {
        assertThrows(IOException.class, () -> Parser.parse(FILE_WITHOUT_EXTENSION));
    }

}
