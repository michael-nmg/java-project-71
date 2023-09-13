package hexlet.code;

import hexlet.code.parsers.Parser;
import hexlet.code.parsers.ParserJson;
import hexlet.code.parsers.ParserYaml;

import java.io.IOException;

public class ParserFactory {
    public static Parser selectOfParser(String fileExtension) throws IOException {
        return switch (fileExtension) {
            case "json" -> new ParserJson();
            case "yml" -> new ParserYaml();
            default -> throw new IOException("Unsupported extension");
        };
    }
}
