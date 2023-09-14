package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.attribute.PosixFilePermissions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {

    private static final int FILE_1_SIZE = 280;
    private static final String FILE_1 = "src/test/resources/file1.json";
    private static final String FILE_2 = "src/test/resources/file2.json";
    private static final String NOT_EXIST_FILE = "src/test/resources/file3.json";
    private static final String NOT_READBLE_FILE = "src/test/resources/unread";
    private static final String SAME_FILE_RESPONSE = "Zero changes. This is the same file.";
    private static final Map<String, Object> EXPECTED_DATA = new HashMap<>();
    private static final Object VALUE_1 = 200;
    private static final Object VALUE_2 = List.of(1, 2, 3, 4);
    private static final Object VALUE_3 = List.of(2, 3, 4, 5);
    private static final Object VALUE_4 = 45;
    private static final Object VALUE_5 = List.of(3, 4, 5);

    @BeforeAll
    static void init() throws IOException {
        EXPECTED_DATA.put("setting1", "Some value");
        EXPECTED_DATA.put("setting2", VALUE_1);
        EXPECTED_DATA.put("setting3", true);
        EXPECTED_DATA.put("key1", "value1");
        EXPECTED_DATA.put("numbers1", VALUE_2);
        EXPECTED_DATA.put("numbers2", VALUE_3);
        EXPECTED_DATA.put("id", VALUE_4);
        EXPECTED_DATA.put("default", null);
        EXPECTED_DATA.put("checked", false);
        EXPECTED_DATA.put("numbers3", VALUE_5);
        EXPECTED_DATA.put("chars1", List.of("a", "b", "c"));
        EXPECTED_DATA.put("chars2", List.of("d", "e", "f"));

        Files.createFile(
                Paths.get(NOT_READBLE_FILE),
                PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("-wx-wx-wx")));
    }

    @AfterAll
    static void after() throws IOException {
        Files.deleteIfExists(Paths.get(NOT_READBLE_FILE));
    }

    @Test
    void testOK() throws IOException {
        String actually = FileUtils.available(FILE_1, FILE_2);
        String expected = "";
        assertEquals(expected, actually);
    }

    @Test
    void testGetExtensionOk() {
        String actual = FileUtils.getExtension(FILE_1);
        String expected = "json";
        assertEquals(expected, actual);
    }

    @Test
    void testReadFileOK() throws IOException {
        int actual = FileUtils.readFile(FILE_1).length;
        assertEquals(FILE_1_SIZE, actual);
    }

    @Test
    void testGetData() throws IOException {
        Map<String, Object> actual = FileUtils.getData(FILE_1);
        assertEquals(EXPECTED_DATA.size(), actual.size());

        for (var entry : actual.entrySet()) {
            assertEquals(EXPECTED_DATA.get(entry.getKey()), entry.getValue());
        }
    }

    @Test
    void testGetExtensionEmpty() {
        String expected = "src/test/resources/unread";
        String actual = FileUtils.getExtension(NOT_READBLE_FILE);

        assertEquals(expected, actual);
    }

    @Test
    void testNotExistFirst() throws IOException {
        String actually = FileUtils.available(NOT_EXIST_FILE, FILE_2);
        String expected = String.format("%s is not exist.", NOT_EXIST_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testNotExistSecond() throws IOException {
        String actually = FileUtils.available(FILE_1, NOT_EXIST_FILE);
        String expected = String.format("%s is not exist.", NOT_EXIST_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testNotReadFirst() throws IOException {
        String actually = FileUtils.available(NOT_READBLE_FILE, FILE_2);
        String expected = String.format("%s is not readable.", NOT_READBLE_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testNotReadSecond() throws IOException {
        String actually = FileUtils.available(FILE_1, NOT_READBLE_FILE);
        String expected = String.format("%s is not readable.", NOT_READBLE_FILE);

        assertEquals(expected, actually);
    }

    @Test
    void testSameFile() throws IOException {
        String actually = FileUtils.available(FILE_1, FILE_1);

        assertEquals(SAME_FILE_RESPONSE, actually);
    }

}
