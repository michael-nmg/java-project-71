package hexlet.code;

import java.io.IOException;
import java.util.function.Predicate;

import java.nio.file.Path;
import java.nio.file.Files;

public class FileChecker {
    private static Predicate<Path> isReadble = Files::isReadable;

    public static String isAvailable(Path first, Path second) throws IOException {
        if (Files.notExists(first)) {
            return String.format("%s is not exist.", first);
        }

        if (Files.notExists(second)) {
            return String.format("%s is not exist.", second);
        }

        if (isReadble.negate().test(first)) {
            return String.format("%s is not readable.", first);
        }

        if (isReadble.negate().test(second)) {
            return String.format("%s is not readable.", second);
        }

        if (Files.isSameFile(first, second)) {
            return "Zero changes. This is the same file.";
        }

        return "";
    }

}
