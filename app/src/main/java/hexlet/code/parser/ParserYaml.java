package hexlet.code.parser;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class ParserYaml implements Parser {

    public Map<String, Object> parse(byte[] data) throws IOException {
        if (data.length == 0) {
            return new HashMap<>();
        }

        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(data, new TypeReference<>() {
        });
    }

}
