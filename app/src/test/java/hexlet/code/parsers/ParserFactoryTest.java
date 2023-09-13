package hexlet.code.parsers;

import hexlet.code.ParserFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserFactoryTest {

    private static final String OTHER = "xxx";
    private static final String JSON = "json";
    private static final String YAML = "yml";

    @Test
    void selectJsonTest() throws IOException {
        Parser actual = ParserFactory.selectOfParser(JSON);
        assertEquals(ParserJson.class, actual.getClass());
    }

    @Test
    void selectYmlTest() throws IOException {
        Parser actual = ParserFactory.selectOfParser(YAML);
        assertEquals(ParserYaml.class, actual.getClass());
    }

    @Test
    void selectOtherTest() throws IOException {
        assertThrows(IOException.class, () -> ParserFactory.selectOfParser(OTHER));
    }

}
