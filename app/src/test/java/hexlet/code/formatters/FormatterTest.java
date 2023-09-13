package hexlet.code.formatters;

import hexlet.code.Formatter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatterTest {

    private static final String OTHER = "xxx";
    private static final String JSON = "json";
    private static final String PLAIN = "plain";
    private static final String STYLISH = "stylish";

//    @Test
//    void selectJsonTest() {
//        Format actual = Formatter.select(JSON);
//        assertEquals(PresentationJson.class, actual.getClass());
//    }

    @Test
    void selectPlainTest() {
        Format actual = Formatter.select(PLAIN);
        assertEquals(FormatPlain.class, actual.getClass());
    }

    @Test
    void selectStylishTest() {
        Format actual = Formatter.select(STYLISH);
        assertEquals(FormatStylish.class, actual.getClass());
    }

    @Test
    void selectOtherTest() {
        assertThrows(RuntimeException.class, () -> Formatter.select(OTHER));
    }

}
