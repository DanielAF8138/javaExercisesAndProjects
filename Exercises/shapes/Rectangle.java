/**
 * Simple rectangle class storing height and width.
 * 
 * @author CS159 Instructors
 * @version 03/25/2021
 */
public class Rectangle {

    private final int width;
    private final int height;

    /**
     * Initialize the rectangle.
     * 
     * @param width The height
     * @param height The width
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle other = (Rectangle) obj;
        return width == other.width && height == other.height;
    }

    @Override
    public String toString() {
        return "R " + width + " " + height;
    }

}
