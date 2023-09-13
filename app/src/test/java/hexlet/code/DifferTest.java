package hexlet.code;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static final String EXTENDED = "stylish";
    private static final String FILE_1 = "src/test/resources/file1.json";
    private static final String FILE_2 = "src/test/resources/file2.json";
    private static final String EMPTY_FILE = "src/test/resources/emptyfile.json";
    private static final String EXPECTED_DATA = "{\n"
            + "    chars1: [a, b, c]\n"
            + "  - chars2: [d, e, f]\n"
            + "  + chars2: false\n"
            + "  - checked: false\n"
            + "  + checked: true\n"
            + "  - default: null\n"
            + "  + default: [value1, value2]\n"
            + "  - id: 45\n"
            + "  + id: null\n"
            + "  - key1: value1\n"
            + "  + key2: value2\n"
            + "    numbers1: [1, 2, 3, 4]\n"
            + "  - numbers2: [2, 3, 4, 5]\n"
            + "  + numbers2: [22, 33, 44, 55]\n"
            + "  - numbers3: [3, 4, 5]\n"
            + "  + numbers4: [4, 5, 6]\n"
            + "  + obj1: {nestedKey=value, isNested=true}\n"
            + "  - setting1: Some value\n"
            + "  + setting1: Another value\n"
            + "  - setting2: 200\n"
            + "  + setting2: 300\n"
            + "  - setting3: true\n"
            + "  + setting3: none\n"
            + "}";

    @Test
    void testGenerateDefault() throws IOException {
        String actual = Differ.generate(FILE_1, FILE_2);
        assertEquals(EXPECTED_DATA, actual);
    }

    @Test
    void testGenerateExtended() throws IOException {
        String actual = Differ.generate(FILE_1, FILE_2, EXTENDED);
        assertEquals(EXPECTED_DATA, actual);
    }

    @Test
    void emptyTest() throws IOException {
        String actual = Differ.generate(EMPTY_FILE, EMPTY_FILE);
        String expected = "{}";

        assertEquals(expected, actual);
    }

}
