package hexlet.code.parser;

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
