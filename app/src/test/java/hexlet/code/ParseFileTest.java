package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParseFileTest {

    private static Path filePath = Paths.get("src/test/resources/file1.json");
    private static Path emptyFilePath = Paths.get("src/test/resources/emptyfile.json");
    private static Map<String, Object> expecteds = new HashMap<>();

    @BeforeAll
    static void init() {
        expecteds.put("host", "hexlet.io");
        expecteds.put("timeout", 50);
        expecteds.put("proxy", "123.234.53.22");
        expecteds.put("follow", false);
    }

    @Test
    void testParse() throws IOException {
        Map<String, Object> result = ParseFile.parse(filePath);

        for (var entry : result.entrySet()) {
            assertEquals(expecteds.get(entry.getKey()), result.get(entry.getKey()));
        }
    }

    @Test
    void testEmpty() throws IOException {
        assertThrows(MismatchedInputException.class, () -> ParseFile.parse(emptyFilePath));
    }

}
