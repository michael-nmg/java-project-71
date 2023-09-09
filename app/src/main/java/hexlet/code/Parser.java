package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.io.IOException;

public class Parser {

    private static final ObjectMapper MAPPER_YML = new YAMLMapper();
    private static final ObjectMapper MAPPER_JSON = new ObjectMapper();

    public static Map<String, Object> parse(String filePath) throws IOException {
        var extension = getExtension(filePath);

        if (extension.isEmpty()) {
            throw new IOException("Not extention this file.");
        }

        return switch (extension.get()) {
            case "json" -> parseJson(filePath);
            default -> parseYml(filePath);
        };
    }

    private static Optional<String> getExtension(String filePath) {
        return Optional.ofNullable(filePath)
                .filter(str -> str.contains("."))
                .map(str -> str.substring(filePath.lastIndexOf(".") + 1))
                .map(String::toLowerCase);
    }

    private static Map<String, Object> parseJson(String filePath) throws IOException {
        File from = new File(filePath);
        return MAPPER_JSON.readValue(from, new TypeReference<>() {
        });
    }

    private static Map<String, Object> parseYml(String filePath) throws IOException {
        File from = new File(filePath);
        return MAPPER_YML.readValue(from, new TypeReference<>() {
        });
    }

}
