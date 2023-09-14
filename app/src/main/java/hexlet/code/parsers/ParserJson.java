package hexlet.code.parsers;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public final class ParserJson implements Parser {

    public Map<String, Object> parse(byte[] data) throws IOException {
        if (data.length == 0) {
            return new HashMap<>();
        }

        return new ObjectMapper().readValue(data, new TypeReference<>() {
        });
    }

}
