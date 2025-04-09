import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

/**
 * CS 159 Exam 2: File I/O methods for loading and saving collections of
 * Rectangle and Square objects.
 * 
 * @author Daniel Fuller
 * @version 06/03/2023
 */
public class ShapeUtils {

    /*
     * This work complies with the JMU Honor Code.  
     * I have neither received nor given help on this test.  
     * I will not share information about this test with 
     * students who have not yet completed it.
     * 
     * Daniel Fuller
     */

    /**
     * Save the provided collection of Rectangle objects to a text file, one per
     * line. The format for a Rectangle is "R width height" and the format for a
     * square is "S size", where width, height, and size are positive integer
     * values. See the accompanying shapes.txt file for an example of the
     * correct format. Notice that the Rectangle and Square toString methods
     * return appropriately formatted strings.
     * 
     * @param rectangles collection of Rectangle objects
     * @param fileName name of the file where the data should be stored
     * @throws FileNotFoundException if file cannot be opened for writing
     */
    public static void saveRectangles(ArrayList<Rectangle> rectangles,
            String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileName);
        for (Rectangle r: rectangles) {
            pw.println(r);
        }
        pw.close();
    }

    /**
     * Read a text file containing Rectangle and Square specifications. The
     * format is the same as that described in saveRectangles. See shapes.txt
     * for a properly formatted example.
     * 
     * You may assume that the file is correctly formatted *except* that
     * non-integers may appear in width, height, or size locations in the file.
     * If any non-integer is encountered, this method must return an empty
     * ArrayList (of size zero).
     * 
     * @param fileName name of the file to load
     * @return collection of shape objects stored in the file, or an empty
     *     ArrayList if the file contains errors
     * @throws FileNotFoundException if file cannot be opened for reading
     */
    public static ArrayList<Rectangle> loadRectangles(String fileName)
            throws FileNotFoundException {
        
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        
        ArrayList<Rectangle> returns = new ArrayList<Rectangle>();
        
        try {
            while (s.hasNext()) {
                String string = s.next();
                
                if (string.equals("R")) {
                    returns.add(new Rectangle(s.nextInt(), s.nextInt()));
                } else {
                    returns.add(new Square(s.nextInt()));
                }
            }
        } catch (InputMismatchException e) {
            returns.clear();
        }
        s.close();
        return returns;
    }

}
