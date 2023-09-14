package hexlet.code.parsers;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class ParserYaml implements Parser {

    public Map<String, Object> parse(byte[] data) throws IOException {
        if (data.length == 0) {
            return new HashMap<>();
        }

        return new YAMLMapper().readValue(data, new TypeReference<>() {
        });
    }

}
