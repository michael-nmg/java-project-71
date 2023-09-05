package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindingDifferences {

    public static Map<String, Map<String, Object>> search(Map<String, Object> first, Map<String, Object> second) {
        Set<String> allKeys = new HashSet<>(first.keySet());
        allKeys.addAll(second.keySet());

        return allKeys.stream().collect(Collectors.toMap(
                Function.identity(),
                key -> separation(key, first, second),
                (o1, o2) -> o1, TreeMap::new));
    }

    private static Map<String, Object> separation(String key, Map<String, Object> first, Map<String, Object> second) {
        boolean fKey = first.containsKey(key);
        boolean sKey = second.containsKey(key);
        Map<String, Object> result = new TreeMap<>(Comparator.reverseOrder());

        if (!fKey) {
            result.put("+", second.get(key));
        }

        if (!sKey) {
            result.put("-", first.get(key));
        }

        if (fKey && sKey) {
            if (first.get(key).equals(second.get(key))) {
                result.put(" ", first.get(key));
            } else {
                result.put("-", first.get(key));
                result.put("+", second.get(key));
            }
        }

        return result;
    }

}
