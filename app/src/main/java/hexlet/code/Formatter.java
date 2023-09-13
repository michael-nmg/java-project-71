package hexlet.code;

import hexlet.code.formatters.Format;
import hexlet.code.formatters.FormatJson;
import hexlet.code.formatters.FormatPlain;
import hexlet.code.formatters.FormatStylish;

public class Formatter {

    public static Format select(String format) throws RuntimeException {
        return switch (format) {
            case "plain" -> new FormatPlain();
            case "json" -> new FormatJson();
            case "stylish" -> new FormatStylish();
            default -> throw new RuntimeException("Unused format.");
        };
    }
}
