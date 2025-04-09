import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for static methods in the ShapeUtils class.
 * 
 * @author CS159 Instructors
 * @version 03/25/2021
 */
public class ShapeUtilsTest {

    @BeforeEach
    public void setUp() throws IOException {
        PrintWriter pw = new PrintWriter("rectangles.txt");
        pw.println("R 3 2");
        pw.println("R 5 7");
        pw.println("R 111 1");
        pw.close();

        pw = new PrintWriter("squares.txt");
        pw.println("S 3");
        pw.println("S 5");
        pw.println("S 111");
        pw.close();

        pw = new PrintWriter("both.txt");
        pw.println("S 9");
        pw.println("R 111 1");
        pw.close();

        pw = new PrintWriter("bad_square.txt");
        pw.println("S 1");
        pw.println("S b");
        pw.close();

        pw = new PrintWriter("bad_rect_1.txt");
        pw.println("R 3 2");
        pw.println("R a 7");
        pw.println("R 111 1");
        pw.close();

        pw = new PrintWriter("bad_rect_2.txt");
        pw.println("R 3 2");
        pw.println("R 5 Ldfdf");
        pw.println("R 111 1");
        pw.close();
    }

    @AfterEach
    public void tearDown() {
        List<String> names = List.of("rectangles.txt", "squares.txt",
                "both.txt", "bad_square.txt", "bad_rect_1.txt",
                "bad_rect_2.txt", "write_squares.txt", "write_rect.txt",
                "write_both.txt");
        for (String name : names) {
            File n = new File(name);
            n.delete();
        }
    }

    // TESTS FOR LOAD

    @Test
    void testLoadRectanglesOnly() throws FileNotFoundException {
        ArrayList<Rectangle> result = ShapeUtils.loadRectangles(
                "rectangles.txt");
        List<Rectangle> expected = List.of(new Rectangle(3, 2),
                new Rectangle(5, 7), new Rectangle(111, 1));
        assertEquals(expected, result);
    }

    @Test
    void testLoadSquaresOnly() throws FileNotFoundException {
        ArrayList<Rectangle> result = ShapeUtils.loadRectangles("squares.txt");
        List<Rectangle> expected = List.of(new Square(3), new Square(5),
                new Square(111));
        assertEquals(expected, result);
    }

    @Test
    void testLoadRectanglesAndSquares() throws FileNotFoundException {
        ArrayList<Rectangle> result = ShapeUtils.loadRectangles("both.txt");
        List<Rectangle> expected = List.of(new Square(9),
                new Rectangle(111, 1));
        assertEquals(expected, result);
    }

    @Test
    void testLoadBadSquareShouldResultInSizeZeroArrayList()
            throws FileNotFoundException {
        ArrayList<Rectangle> result = ShapeUtils.loadRectangles(
                "bad_square.txt");
        assertEquals(0, result.size());
    }

    @Test
    void testLoadBadRectangleShouldResultInSizeZeroArrayList()
            throws FileNotFoundException {
        ArrayList<Rectangle> result = ShapeUtils.loadRectangles(
                "bad_rect_1.txt");
        assertEquals(0, result.size());
        result = ShapeUtils.loadRectangles("bad_rect_2.txt");
        assertEquals(0, result.size());
    }

    @Test
    void testLoadThrowsFileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> {
            ShapeUtils.loadRectangles("/this/isnot/a/file.txt");
        });
    }

    // TESTS FOR SAVE

    @Test
    void testSaveJustSquares() throws FileNotFoundException {
        ArrayList<Rectangle> rects = new ArrayList<>();
        rects.add(new Square(21));
        rects.add(new Square(7));
        rects.add(new Square(13));
        ShapeUtils.saveRectangles(rects, "write_squares.txt");
        Scanner scan = new Scanner(new File("write_squares.txt"));
        String actual = scan.useDelimiter("\\Z").next();
        actual = actual.replace("\r", "");
        String expected = "S 21\nS 7\nS 13";
        assertEquals(expected, actual.stripTrailing());
    }

    @Test
    void testSaveJustRectangles() throws FileNotFoundException {
        ArrayList<Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle(2, 21));
        rects.add(new Rectangle(1, 7));
        ShapeUtils.saveRectangles(rects, "write_rect.txt");
        Scanner scan = new Scanner(new File("write_rect.txt"));
        String actual = scan.useDelimiter("\\Z").next();
        actual = actual.replace("\r", "");
        String expected = "R 2 21\nR 1 7";
        assertEquals(expected, actual.stripTrailing());
    }

    @Test
    void testSaveBoth() throws FileNotFoundException {
        ArrayList<Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle(2, 21));
        rects.add(new Square(7));
        rects.add(new Rectangle(1, 7));
        ShapeUtils.saveRectangles(rects, "write_both.txt");
        Scanner scan = new Scanner(new File("write_both.txt"));
        String actual = scan.useDelimiter("\\Z").next();
        actual = actual.replace("\r", "");
        String expected = "R 2 21\nS 7\nR 1 7";
        assertEquals(expected, actual.stripTrailing());
    }

    @Test
    void testSaveThrowsFileNotFoundException() {
        ArrayList<Rectangle> rects = new ArrayList<>();
        assertThrows(FileNotFoundException.class, () -> {
            ShapeUtils.saveRectangles(rects, "/this/isnot/a/file.txt");
        });
    }

}
