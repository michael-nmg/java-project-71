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
    private static final String DEFAULT_EXPECTED = "{\n"
            + "  - follow: false\n"
            + "    host: hexlet.io\n"
            + "  - proxy: 123.234.53.22\n"
            + "  - timeout: 50\n"
            + "  + timeout: 20\n"
            + "  + verbose: true\n"
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

        assertEquals(0, expectedCode);
        assertEquals(DEFAULT_EXPECTED, out.toString());
    }

    @Test
    void testFileChecker() {
        int expectedCode = commandLine.execute("-f=stylish", FILE_1, FILE_1);

        assertEquals(0, expectedCode);
        assertEquals(SAME_FILE_RESPONSE, out.toString());
    }

}
