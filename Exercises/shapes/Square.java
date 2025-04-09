/**
 * A square is-a rectangle with equal height and width.
 * 
 * @author CS159 Instructors
 * @version 03/25/2021
 */
public class Square extends Rectangle {

    /**
     * Initialize a square as a rectangle with equal sides.
     * 
     * @param size Width and height
     */
    public Square(int size) {
        super(size, size);
    }

    @Override
    public String toString() {
        return "S " + getWidth();
    }

}
