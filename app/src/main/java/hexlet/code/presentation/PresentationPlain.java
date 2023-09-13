package hexlet.code.presentation;

import java.util.Map;
import java.util.stream.Collectors;

import hexlet.code.Difference;

public class PresentationPlain implements Presentation {
    public String presentation(Map<String, Difference> data) {
        if (data.isEmpty()) {
            return "{}";
        }

        return data.entrySet().stream()
                .map(PresentationPlain::convertor)
                .collect(Collectors.joining());
    }

    private static String convertor(Map.Entry<String, Difference> entry) {
        String key = entry.getKey();
        Difference diff = entry.getValue();
        return switch (diff.getStatus()) {
            case "removed" -> String.format("Property '%s' was removed%n", key);
            case "unchanged" -> String.format("Property '%s' was unchanged%n", key);
            case "added" -> String.format("Property '%s' was added with value: %s%n", key, diff.getValue1());
            default -> String.format("Property '%s' was updated. From '%s' to '%s'%n",
                    key, diff.getValue1(), diff.getValue2());
        };
    }

}
