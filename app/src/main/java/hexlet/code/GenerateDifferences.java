package hexlet.code;

import hexlet.code.presentation.PresentationFactory;

import java.io.IOException;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Function;

import static hexlet.code.FileUtils.getData;

public class GenerateDifferences {

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate("stylish", filePath1, filePath2);
    }

    public static String generate(String format, String filePath1, String filePath2) throws IOException {
        var data = getDiff(getData(filePath1), getData(filePath2));
        return PresentationFactory.select(format).presentation(data);
    }

    private static Map<String, Difference> getDiff(Map<String, Object> first, Map<String, Object> second) {
        return Stream.concat(first.keySet().stream(), second.keySet().stream())
                .collect(Collectors.toMap(
                        Function.identity(),
                        key -> separation(key, first, second),
                        (o1, o2) -> o1, TreeMap::new));
    }

    private static Difference separation(String key, Map<String, Object> first, Map<String, Object> second) {
        if (!first.containsKey(key)) {
            return new Difference("added", second.get(key));
        } else if (!second.containsKey(key)) {
            return new Difference("removed", first.get(key));
        } else if (Objects.equals(first.get(key), second.get(key))) {
            return new Difference("unchanged", first.get(key));
        } else {
            return new Difference("updated", first.get(key), second.get(key));
        }
    }

}
