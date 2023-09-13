package hexlet.code.presentation;

import java.util.Map;
import java.util.stream.Collectors;

import hexlet.code.Difference;

public class PresentationStylish implements Presentation {

    public String presentation(Map<String, Difference> data) {
        if (data.isEmpty()) {
            return "{}";
        }

        return "{\n" + data.entrySet().stream()
                .map(PresentationStylish::convertor)
                .collect(Collectors.joining()) + "}";
    }

    private static String convertor(Map.Entry<String, Difference> entry) {
        String key = entry.getKey();
        Difference diff = entry.getValue();

        return switch (diff.getStatus()) {
            case "added" -> String.format("  + %s: %s%n", key, diff.getValue1());
            case "removed" -> String.format("  - %s: %s%n", key, diff.getValue1());
            case "unchanged" -> String.format("    %s: %s%n", key, diff.getValue1());
            default -> String.format("  - %s: %s%n  + %s: %s%n", key, diff.getValue1(), key, diff.getValue2());
        };
    }

}
