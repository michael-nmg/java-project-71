package hexlet.code.parsers;

import java.util.Map;
import java.io.IOException;

public interface Parser {
    Map<String, Object> parse(byte[] filePath) throws IOException;
}
