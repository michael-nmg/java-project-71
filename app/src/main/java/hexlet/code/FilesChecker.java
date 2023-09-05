package hexlet.code;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Files;

public class FilesChecker {

    public static String available(Path first, Path second) throws IOException {
        String result = exist(first, second);

        if (!result.isEmpty()) {
            return result;
        }

        result += readbles(first, second);

        if (!result.isEmpty()) {
            return result;
        }

        return identical(first, second);
    }

    private static String readbles(Path first, Path second) {
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
