package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParseFileTest {

    private static Path filePath = Paths.get("src/test/resources/file1.json");

    @Test
    void testParse() throws IOException {
        Map<String, Object> result = ParseFile.parse(filePath);
        assertThat(result)
                .containsEntry("host", "hexlet.io")
                .containsEntry("timeout", 50)
                .containsEntry("proxy", "123.234.53.22")
                .containsEntry("follow", false);
    }
}
