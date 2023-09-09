package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.attribute.PosixFilePermissions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilesCheckerTest {

    private static final String FILE_1 = "src/test/resources/file1.json";
    private static final String FILE_2 = "src/test/resources/file2.json";
    private static final String NOT_EXIST_FILE = "src/test/resources/file3.json";
    private static final String NOT_READBLE_FILE = "src/test/resources/unread.json";
    private static final String SAME_FILE_RESPONSE = "Zero changes. This is the same file.";


    @BeforeAll
    static void init() throws IOException {
        Files.createFile(
                Paths.get(NOT_READBLE_FILE),
                PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("-wx-wx-wx")));
    }

    @Test
    void testOK() throws IOException {
        String actually = FilesChecker.available(FILE_1, FILE_2);
        String expected = "";

        assertEquals(expected, actually);
    }

    @Test
    void testNotExistFirst() throws IOException {
        String actually = FilesChecker.available(NOT_EXIST_FILE, FILE_2);
        String expected = String.format("%s is not exist.", NOT_EXIST_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testNotExistSecond() throws IOException {
        String actually = FilesChecker.available(FILE_1, NOT_EXIST_FILE);
        String expected = String.format("%s is not exist.", NOT_EXIST_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testNotReadFirst() throws IOException {
        String actually = FilesChecker.available(NOT_READBLE_FILE, FILE_2);
        String expected = String.format("%s is not readable.", NOT_READBLE_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testNotReadSecond() throws IOException {
        String actually = FilesChecker.available(FILE_1, NOT_READBLE_FILE);
        String expected = String.format("%s is not readable.", NOT_READBLE_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testSameFile() throws IOException {
        String actually = FilesChecker.available(FILE_1, FILE_1);

        assertEquals(SAME_FILE_RESPONSE, actually);
    }

    @AfterAll
    static void after() throws IOException {
        Files.deleteIfExists(Paths.get(NOT_READBLE_FILE));
    }

}
