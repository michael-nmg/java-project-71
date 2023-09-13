package hexlet.code;

import picocli.CommandLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private final App app = new App();
    private final CommandLine commandLine = new CommandLine(app);
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private static final String FILE_1 = "src/test/resources/file1.json";
    private static final String FILE_2 = "src/test/resources/file2.json";
    private static final String SAME_FILE_RESPONSE = "Zero changes. This is the same file.\n";
    private static final int SUCCES_CODE = 0;
//    private static final int ERROR_CODE = 1;
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
            + "}\n";

    @BeforeEach
    public void setUpStreams() {
        out.reset();
        err.reset();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testDefaultOk() {
        int expectedCode = commandLine.execute("-f=stylish", FILE_1, FILE_2);

        assertEquals(SUCCES_CODE, expectedCode);
        assertEquals(EXPECTED_DATA, out.toString());
    }

    @Test
    void testFileChecker() {
        int expectedCode = commandLine.execute("-f=stylish", FILE_1, FILE_1);

        assertEquals(1, expectedCode);
        assertEquals(SAME_FILE_RESPONSE, out.toString());
    }

}
