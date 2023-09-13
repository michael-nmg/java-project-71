package hexlet.code.presentation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PresentationFactoryTest {

    private static final String OTHER = "xxx";
    private static final String JSON = "json";
    private static final String PLAIN = "plain";
    private static final String STYLISH = "stylish";

//    @Test
//    void selectJsonTest() {
//        Presentation actual = PresentationFactory.select(JSON);
//        assertEquals(PresentationJson.class, actual.getClass());
//    }

    @Test
    void selectPlainTest() {
        Presentation actual = PresentationFactory.select(PLAIN);
        assertEquals(PresentationPlain.class, actual.getClass());
    }

    @Test
    void selectStylishTest() {
        Presentation actual = PresentationFactory.select(STYLISH);
        assertEquals(PresentationStylish.class, actual.getClass());
    }

    @Test
    void selectOtherTest() {
        assertThrows(RuntimeException.class, () -> PresentationFactory.select(OTHER));
    }

}
