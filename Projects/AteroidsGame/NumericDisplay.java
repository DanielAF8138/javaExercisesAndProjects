/**
 * NumericDisplay for Asteroid Game.
 * @author fulle2da
 * @version 29/03/2023
 *
 */
public class NumericDisplay implements Drawable {
    
    private String prefix;
    private int value;
    private Point location;
    
    
    /**
     * NumericDisplay constructor.
     * @param xPos xposition
     * @param yPos yposition
     * @param prefix prefix
     * @param value value after prefix 
     */
    public NumericDisplay(int xPos, int yPos, String prefix, int value) {
        this.prefix = prefix;
        this.value = value;
        this.location = new Point(xPos, yPos);
    }
    
    public Point getLocation() {
        return this.location;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * draw interface.
     */
    public void draw() {
        String display = String.format("%s%d", prefix, value);
        StdDraw.textLeft(location.getX(), location.getY(), display);
    }
}