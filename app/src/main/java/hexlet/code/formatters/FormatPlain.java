package hexlet.code.formatters;

import java.util.Map;
import java.util.Collection;
import java.util.stream.Collectors;

import hexlet.code.Difference;

public class FormatPlain implements Format {
    public String presentation(Map<String, Difference> data) {
        if (data.isEmpty()) {
            return "";
        }

        return data.entrySet().stream()
                .map(entry -> convertor(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    private static String convertor(String key, Difference diff) {
        return switch (diff.getStatus()) {
            case "removed" -> String.format("Property '%s' was removed%n", key);
            case "added" -> String.format("Property '%s' was added with value: %s%n",
                    key, prepare(diff.getValue1()));
            case "updated" -> String.format("Property '%s' was updated. From %s to %s%n",
                    key, prepare(diff.getValue1()), prepare(diff.getValue2()));
            default -> "";
        };
    }

    private static String prepare(Object value) {
        if (value != null) {
            if (value instanceof Collection<?> || value instanceof Map<?, ?>) {
                return "[complex value]";
            } else if (value.getClass() == String.class) {
                return "'" + value + "'";
            } else {
                return value.toString();
            }
        }
        return "null";
    }

}
