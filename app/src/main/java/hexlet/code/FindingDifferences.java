package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindingDifferences {

    public static Map<String, Map<String, Object>> search(
            Map<String, Object> first,
            Map<String, Object> second) {
        Set<String> allKeys = new HashSet<>(first.keySet());
        allKeys.addAll(second.keySet());
        return allKeys.stream().collect(Collectors.toMap(
                Function.identity(),
                key -> separate(key, first, second),
                (o1, o2) -> o1, TreeMap::new));
    }

    private static Map<String, Object> separate(
            String key,
            Map<String, Object> first,
            Map<String, Object> second) {
        Map<String, Object> result = new TreeMap<>(Comparator.reverseOrder());
        String prefix;
        Object value;

        if (first.containsKey(key) && second.containsKey(key)) {
            if (first.get(key).equals(second.get(key))) {
                prefix = " ";
                value = first.get(key);
            } else {
                result.put("-", first.get(key));
                result.put("+", second.get(key));
                return result;
            }
        } else {
            if (first.containsKey(key)) {
                prefix = "-";
                value = first.get(key);
            } else {
                prefix = "+";
                value = second.get(key);
            }
        }
        result.put(prefix, value);
        return result;
    }

}
