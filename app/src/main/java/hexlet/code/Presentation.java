package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;

public class Presentation {

    public static String plainTextPresentation(Map<String, Map<String, Object>> calcDiff) {
        if (calcDiff.isEmpty()) {
            return "{}";
        }
        return "{\n" + calcDiff.entrySet().stream()
                .map(Presentation::enrtyToString)
                .collect(Collectors.joining()) + "}\n";
    }

    private static String enrtyToString(Map.Entry<String, Map<String, Object>> entry) {
        var key = entry.getKey();
        var value = entry.getValue();
        return value.entrySet().stream()
                .map(pair -> String.format("  %s %s: %s%n", pair.getKey(), key, pair.getValue()))
                .collect(Collectors.joining(""));
    }

}
