package hexlet.code.formatters;

import hexlet.code.Difference;

import java.util.Map;

public interface Format {
    String presentation(Map<String, Difference> data);
}
