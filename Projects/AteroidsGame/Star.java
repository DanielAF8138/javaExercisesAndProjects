/**
 * Star class for Asteroids Game.
 * @author fulle2da
 * @version 29/03/2023
 */
public class Star implements Drawable {
    
    public static final int STAR_RADIUS = 1;
    
    private Point location;
    
    /**
     * Star constructor.
     * @param x xposition
     * @param y yposition
     */
    public Star(double x, double y) {
        this.location = new Point(x, y);
    }
    
    public Point getLocation() {
        return location;
    }
    
    /**
     * draw interface.
     */
    public void draw() {
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(location.getX(), location.getY(), STAR_RADIUS);
    }
}