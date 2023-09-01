package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileCheckerTest {

    private static Path file1 = Paths.get("src/test/resources/file1.json");
    private static Path file2 = Paths.get("src/test/resources/file2.json");
    private static Path notExistFile = Paths.get("src/test/resources/file3.json");

    @Test
    void testOK() throws Exception {
        assertTrue(FileChecker.isAvailable(file1, file2));
    }

    @Test
    void testNotExist() throws Exception {
        assertThrows(Exception.class, () -> FileChecker.isAvailable(file1, notExistFile));
    }

    @Test
    void testNotRead() throws Exception {
        assertThrows(Exception.class, () -> FileChecker.isAvailable(file1, notExistFile));
    }

    @Test
    void testSameFile() throws Exception {
        assertThrows(Exception.class, () -> FileChecker.isAvailable(file1, file1));
    }

}
