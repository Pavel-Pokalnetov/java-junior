package loc.homework;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ToolsTest {
    @Test
    void testGetAverageEventNumber_ValidParametrs() {
        assertEquals(6.0, Tools.getAverageEvenNumbers(Arrays.asList(8, 2, 5, 8, 3, 9)));
        assertEquals(3.0, Tools.getAverageEvenNumbers(Arrays.asList(6, 0, 1, 1, 1, 3)));
        assertEquals(1.3333333333333333, Tools.getAverageEvenNumbers(Arrays.asList(1, 4, 7, 0, 9, 0)));
        assertEquals(6.0, Tools.getAverageEvenNumbers(Arrays.asList(8, 2, 5, 8, 3, 9)));
        assertEquals(2.0, Tools.getAverageEvenNumbers(Arrays.asList(0, 2, 4)));
    }

    @Test
    void testGetAverageEventNumber_NullArguments() {
        assertNull(Tools.getAverageEvenNumbers(null));
        assertNull(Tools.getAverageEvenNumbers(new ArrayList<Integer>()));
    }

    @Test
    void testGetAverageEventNumber_NotEventArguments() {
        assertEquals(0.0, Tools.getAverageEvenNumbers(Arrays.asList(-7, -3, -1, -5, 1, 9, 5, 3, 13)));
        assertEquals(0.0, Tools.getAverageEvenNumbers(Arrays.asList(-1, 1, 3, 5)));
        assertEquals(0.0, Tools.getAverageEvenNumbers(Arrays.asList(1, 1, 1, 1, 9, 9, 99999)));
    }
}