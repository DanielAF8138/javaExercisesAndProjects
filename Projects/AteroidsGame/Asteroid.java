   /**
 * Asteroid Class.
 * @author fulle2da
 * @version 14/04/2023
 */
public class Asteroid extends Enemy {
    
    public static final int ASTEROID_SPEED = 1;
    
    /**
     * Asteroid constructor.
     * @param size size
     */
    public Asteroid(AsteroidSize size) {
        super(ASTEROID_SPEED, size.getRadius(), size.getPoints());
    }
    
    /**
     * draw interface.
     */
    public void draw() {   
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.circle(getPose().getX(), getPose().getY(), getRadius());
    }
    
    /**
     * update interface.
     */
    public void update() {
        super.update();
    }
}