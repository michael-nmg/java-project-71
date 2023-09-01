package hexlet.code;

import java.util.function.Predicate;

import java.nio.file.Path;
import java.nio.file.Files;

public class FileChecker {
    private static Predicate<Path> isReadble = Files::isReadable;

    public static boolean isAvailable(Path first, Path second) throws Exception {
        if (Files.notExists(first)) {
            throw new Exception("First file is not exist.");
        } else if (Files.notExists(second)) {
            throw new Exception("Second file is not exist.");
        } else if (Files.isSameFile(first, second)) {
            throw new Exception("Zero changes are the same file.");
        } else if (isReadble.negate().test(first)) {
            throw new Exception("Not readable first file");
        } else if (isReadble.negate().test(second)) {
            throw new Exception("Not readable second file");
        }
        return true;
    }
}
