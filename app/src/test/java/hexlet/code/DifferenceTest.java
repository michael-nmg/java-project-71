package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DifferenceTest {

    private static Difference expectedObject;
    private static final String STATUS = "status";
    private static final Object VALUE_1 = "value";
    private static final Object VALUE_2 = 1;

    @BeforeEach
    void init() {
        expectedObject = new Difference(STATUS, VALUE_1, VALUE_2);
    }

    @Test
    void getStatus() {
        String actual = expectedObject.getStatus();
        assertEquals(STATUS, actual);
    }

    @Test
    void getValue1() {
        Object actual = expectedObject.getValue1();
        assertEquals(VALUE_1, actual);
    }

    @Test
    void getValue2() {
        Object actual = expectedObject.getValue2();
        assertEquals(VALUE_2, actual);
    }

    @Test
    void setStatus() {
        String expected = "another status";
        Difference actualObj = new Difference();
        actualObj.setStatus(expected);
        assertEquals(expected, actualObj.getStatus());
    }

    @Test
    void setValue1() {
        Object expected = "another value";
        Difference actualObj = new Difference();
        actualObj.setValue1(expected);
        assertEquals(expected, actualObj.getValue1());
    }

    @Test
    void setValue2() {
        Object expected = 0;
        Difference actualObj = new Difference();
        actualObj.setValue2(expected);
        assertEquals(expected, actualObj.getValue2());
    }

    @Test
    void testEquals() {
        Difference actualObj = new Difference(STATUS, VALUE_1, VALUE_2);
        assertEquals(expectedObject, actualObj);

        actualObj.setStatus("another status");
        assertNotEquals(expectedObject, actualObj);

        Object actualNull = null;
        String actualAnotherClass = "";
        assertNotEquals(expectedObject, actualNull);
        assertNotEquals(expectedObject, actualAnotherClass);
    }

    @Test
    void testHashCode() {
        int expected = expectedObject.hashCode();
        Difference actualObj = new Difference(STATUS, VALUE_1, VALUE_2);
        int actual = expectedObject.hashCode();

        assertEquals(expected, actual);

        actualObj.setStatus("another status");
        actual = actualObj.hashCode();

        assertNotEquals(expected, actual);
    }

}
