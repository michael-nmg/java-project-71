package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.attribute.PosixFilePermissions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilesCheckerTest {

    private static final Path FILE_1 = Paths.get("src/test/resources/file1.json");
    private static final Path FILE_2 = Paths.get("src/test/resources/file2.json");
    private static final Path NOT_EXIST_FILE = Paths.get("src/test/resources/file3.json");
    private static final Path NOT_READBLE_FILE = Paths.get("src/test/resources/unread.json");

    @BeforeAll
    static void init() throws IOException {
        Files.createFile(
                NOT_READBLE_FILE,
                PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("-wx-wx-wx")));
    }

    @Test
    void testOK() throws IOException {
        String actually = FilesChecker.available(FILE_1, FILE_2);
        String expected = "";

        assertEquals(actually, expected);
    }

    @Test
    void testNotExistFirst() throws IOException {
        String actually = FilesChecker.available(NOT_EXIST_FILE, FILE_2);
        String expected = String.format("%s is not exist.", NOT_EXIST_FILE);

        assertEquals(actually, expected);
    }

    @Test
    void testNotExistSecond() throws IOException {
        String actually = FilesChecker.available(FILE_1, NOT_EXIST_FILE);
        String expected = String.format("%s is not exist.", NOT_EXIST_FILE);

        assertEquals(actually, expected);
    }

    @Test
    void testNotReadFirst() throws IOException {
        String actually = FilesChecker.available(NOT_READBLE_FILE, FILE_2);
        String expected = String.format("%s is not readable.", NOT_READBLE_FILE);

        assertEquals(actually, expected);
    }

    @Test
    void testNotReadSecond() throws IOException {
        String actually = FilesChecker.available(FILE_1, NOT_READBLE_FILE);
        String expected = String.format("%s is not readable.", NOT_READBLE_FILE);

        assertEquals(actually, expected);
    }

    @Test
    void testSameFile() throws IOException {
        String actually = FilesChecker.available(FILE_1, FILE_1);
        String expected = "Zero changes. This is the same file.";

        assertEquals(actually, expected);
    }

    @AfterAll
    static void after() throws IOException {
        Files.deleteIfExists(NOT_READBLE_FILE);
    }

}