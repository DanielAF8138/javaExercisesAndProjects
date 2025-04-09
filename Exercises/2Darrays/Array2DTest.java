import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Reference tests for the Array2D lab.
 * 
 * Note that this style of organizing tests, with exactly one test method per
 * method being tested, is not typical. The tests are organized this way to
 * simplify grading the lab.
 * 
 * @author Nancy Harris modifications by Nathan Sprague
 * @version 02/03/2021
 * 
 */
public class Array2DTest {

    private double[][] m1;
    private double[][] m2;
    private double[][] m3;
    private double[][] m4;
    private double[][] m5;
    private double[][] m6;

    @BeforeEach
    public void setUp() {

        m1 = new double[][] {{5.25}};

        m2 = new double[][] {{1, 2, 3}, 
                             {1, 2}, 
                             {1, 2, 3, 4}};

        m3 = new double[][] {{1, 2, 3}, 
                             null, 
                             {1, 2, 3, 4}};

        m4 = new double[][] {{1, 2, 3}, 
                             {-1, -2, -3}, 
                             {1, 2, 3}};

        m5 = new double[][] {{1, 2, 3}, 
                             {}, 
                             {1, 2, 3}};

        m6 = new double[][] {{}};

    }

    @Test
    public void testIsRowValid() {
        assertFalse(Array2D.isRowValid(m1, -1));
        assertTrue(Array2D.isRowValid(m1, 0));
        assertFalse(Array2D.isRowValid(m2, 4));
        assertFalse(Array2D.isRowValid(m3, 1));
        assertTrue(Array2D.isRowValid(m2, 2));
        assertFalse(Array2D.isRowValid(m5, 1));
    }

    @Test
    public void testIsColumnValid() {
        assertFalse(Array2D.isColumnValid(m1, -1));
        assertTrue(Array2D.isColumnValid(m1, 0));
        assertFalse(Array2D.isColumnValid(m2, 4));
        assertTrue(Array2D.isColumnValid(m3, 3));
        assertTrue(Array2D.isColumnValid(m2, 3));
    }

    @Test
    public void testcountEntries() {
        assertEquals(1, Array2D.countEntries(m1));
        assertEquals(9, Array2D.countEntries(m2));
        assertEquals(7, Array2D.countEntries(m3));
        assertEquals(9, Array2D.countEntries(m4));
    }

    @Test
    public void testgetRowTotal() {
        assertEquals(5.25, Array2D.getRowTotal(m1, 0), .01);
        assertEquals(10.0, Array2D.getRowTotal(m2, 2), .01);
        assertEquals(10.0, Array2D.getRowTotal(m3, 2), .01);
        assertEquals(-6.0, Array2D.getRowTotal(m4, 1), .01);
        assertEquals(Double.MIN_VALUE, Array2D.getRowTotal(m3, 1), .01);
    }

    @Test
    public void testgetTotal() {
        assertEquals(5.25, Array2D.getTotal(m1), .01);
        assertEquals(16.0, Array2D.getTotal(m3), .01);
        assertEquals(6.0, Array2D.getTotal(m4), .01);
        assertEquals(Double.MIN_VALUE, Array2D.getTotal(m6), .01);
    }

    // UNCOMMENT THE TESTS BELOW IF YOU WANT TO WORK
    // ON THE OPTIONAL METHODS...
    // (Select then Shift-Ctrl-C in Eclipse)

//    @Test
//    public void testgetAverage() {
//        assertEquals(5.25, Array2D.getAverage(m1), .01);
//        assertEquals(2.2857, Array2D.getAverage(m3), .0001);
//        assertEquals(.66667, Array2D.getAverage(m4), .001);
//        assertEquals(Double.MIN_VALUE, Array2D.getAverage(m6), .001);
//    }
//
//    @Test
//    public void testgetColumnTotal() {
//        assertEquals(5.25, Array2D.getColumnTotal(m1, 0), .01);
//        assertEquals(3.0, Array2D.getColumnTotal(m2, 0), .01);
//        assertEquals(4.0, Array2D.getColumnTotal(m3, 3), .01);
//        assertEquals(4.0, Array2D.getColumnTotal(m3, 1), .01);
//        assertEquals(Double.MIN_VALUE, Array2D.getColumnTotal(m3, 4), .01);
//    }
//
//    @Test
//    public void testHighestInRow() {
//        assertEquals(5.25, Array2D.getHighestInRow(m1, 0), .01);
//        assertEquals(2.0, Array2D.getHighestInRow(m2, 1), .01);
//        assertEquals(-1.0, Array2D.getHighestInRow(m4, 1), .01);
//        assertEquals(Double.MIN_VALUE, Array2D.getHighestInRow(m4, 3), .01);
//    }

}
