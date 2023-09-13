package hexlet.code.formatters;

import hexlet.code.Difference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FormatJson implements Format {

    public String presentation(Map<String, Difference> data) {
        if (data.isEmpty()) {
            return "[]";
        }

        try {
            return new ObjectMapper().writeValueAsString(prepare(data));
        } catch (JsonProcessingException exception) {
            System.out.println(exception.getMessage());
        }

        return "[]";
    }

    private static List<Map<String, Object>> prepare(Map<String, Difference> data) {
        return data.entrySet().stream()
                .map(entry -> injection(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private static Map<String, Object> injection(String key, Difference value) {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", key);
        map.put("status", value.getStatus());

        switch (value.getStatus()) {
            case "added", "removed", "unchanged" -> map.put("value", value.getValue1());
            case "updated" -> {
                map.put("value1", value.getValue1());
                map.put("value2", value.getValue2());
            }
            default -> throw new RuntimeException("Unsupported status");
        }
        return map;
    }

}
