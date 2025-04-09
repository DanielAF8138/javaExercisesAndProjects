import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Submission tests for the Recursion Practice Lab
 * 
 * @author Nathan Sprague
 * @version 4/16/21
 *
 */
class RecursionTest {

    @Test
    void testContainsNumber() {
        int[] numbers = {1, 3, 9, 0, -4, 11};
        assertTrue(Recursion.containsNumber(0, numbers, 1));
        assertTrue(Recursion.containsNumber(0, numbers, 11));
        assertFalse(Recursion.containsNumber(0, numbers, 50));
    }

    @Test
    void testReverse() {
        int[] numbers1 = {1, 3, 9, 0, -4, 11};
        int[] numbers2 = {1, 2, 3, 4, 5};

        Recursion.reverse(numbers1, 0, numbers1.length - 1);
        assertArrayEquals(new int[] {11, -4, 0, 9, 3, 1}, numbers1);

        Recursion.reverse(numbers2, 0, numbers2.length - 1);
        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, numbers2);

    }

}
