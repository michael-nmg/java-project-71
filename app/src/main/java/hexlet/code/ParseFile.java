package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class ParseFile {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> parse(Path filePath) throws IOException {
        File from = new File(filePath.toString());
        return mapper.readValue(from, new TypeReference<>() {
        });
    }
}
