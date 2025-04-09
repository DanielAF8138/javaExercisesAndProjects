import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * JUnit tests for CollectionExercises.
 * 
 * @author Dee Weikle
 * @version 04/19/2022
 */
public class CollectionExercisesTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(8);
        list.add(12);
        list.add(4);
        list.add(10);
        list.add(13);
        list.add(5);
        list.add(2);
        list.add(12);
        list.add(11);
        list.add(14);
    }

    @Test
    final void removeSmallIntsTest() {
        assertEquals(10, list.size());
        CollectionExercises.removeSmallInts(list, 10);
        assertEquals(6, list.size());
        assertEquals(12, list.get(0));
        assertEquals(13, list.get(2));
        assertEquals(14, list.get(5));
    }

    @Test
    final void containsDuplicatesTest() {
        assertTrue(CollectionExercises.containsDuplicates(list));
        list.remove((Integer) 12);
        assertFalse(CollectionExercises.containsDuplicates(list));
    }

    @Test
    final void inEitherTest() {
        Set<Integer> set = new HashSet<>();
        set.add(8);
        set.add(1);
        set.add(5);
        set.add(4);
        set.add(3);
        set.add(0);
        set.add(6);
        set.add(2);
        set.add(9);
        set.add(7);
        ArrayList<Integer> result = CollectionExercises.inEither(list, set);
        for (int i = 0; i < 15; i++) {
            assertEquals(i, result.get(i));
        }
    }

    @Test
    final void inBothTest() {
        Set<Integer> set = new HashSet<>();
        set.add(8);
        set.add(1);
        set.add(5);
        set.add(4);
        set.add(3);
        set.add(0);
        set.add(6);
        set.add(2);
        set.add(9);
        set.add(7);
        ArrayList<Integer> result = CollectionExercises.inBoth(list, set);
        assertEquals(2, result.get(0));
        assertEquals(4, result.get(1));
        assertEquals(5, result.get(2));
        assertEquals(8, result.get(3));
    }

    @Test
    final void mostFrequentTest() {
        ArrayList<String> strings = new ArrayList<>();
        assertNull(CollectionExercises.mostFrequent(strings));
        strings.add("final");
        strings.add("correct");
        strings.add("trial");
        strings.add("oral");
        strings.add("correct");
        strings.add("oral");
        strings.add("insult");
        strings.add("figure");
        strings.add("trial");
        strings.add("correct");
        strings.add("silver");
        strings.add("correct");
        strings.add("basalt");
        strings.add("trial");
        assertEquals("correct", CollectionExercises.mostFrequent(strings));
    }

}
