package hexlet.code;

import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import hexlet.code.parser.ParserFactory;

public class FileUtils {

    public static String getExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
    }

    public static byte[] readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

    public static Map<String, Object> getData(String filePath) throws IOException {
        String fileExtension = getExtension(filePath);
        return ParserFactory.selectOfParser(fileExtension).parse(readFile(filePath));
    }

    public static String available(String filePath1, String filePath2) throws IOException {
        Path first = Paths.get(filePath1);
        Path second = Paths.get(filePath2);
        String result = exist(first, second);

        if (!result.isEmpty()) {
            return result;
        }

        result += readble(first, second);

        if (!result.isEmpty()) {
            return result;
        }

        return identical(first, second);
    }

    private static String readble(Path first, Path second) {
        if (!Files.isReadable(first)) {
            return String.format("%s is not readable.", first);
        }

        if (!Files.isReadable(second)) {
            return String.format("%s is not readable.", second);
        }

        return "";
    }

    private static String exist(Path first, Path second) {
        if (Files.notExists(first)) {
            return String.format("%s is not exist.", first);
        }

        if (Files.notExists(second)) {
            return String.format("%s is not exist.", second);
        }

        return "";
    }

    private static String identical(Path first, Path second) throws IOException {
        if (Files.isSameFile(first, second)) {
            return "Zero changes. This is the same file.";
        }
        return "";
    }

}
