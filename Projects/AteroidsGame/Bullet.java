/**
 * Bullet class.
 * @author fulle2da
 * @version 08/04/2023
 */
public class Bullet extends GameElement {
    public static final double BULLET_RADIUS = 1.5;
    public static final int BULLET_SPEED = 20;
    public static final int BULLET_DURATION = 20;
    private int counter;
    
    /**
     * Bullet constructor.
     * @param pose bullet position
     */
    public Bullet(Pose pose) {
        super(pose, new Vector2D(pose.getHeading(), BULLET_SPEED), BULLET_RADIUS);
        this.counter = 0;
    }
    
    /**
     * Updates the bullets position.
     */
    @Override
    public void update() {
        this.pose = this.pose.move(velocity);
        if (pose.getX() > GameDriver.SCREEN_WIDTH) {
            this.setDestroyed(true);
        } else if (pose.getX() < 0) {
            this.setDestroyed(true);
        }
        if (pose.getY() > GameDriver.SCREEN_HEIGHT) {
            this.setDestroyed(true);
        } else if (pose.getY() < 0) {
            this.setDestroyed(true);
        } 
        if (this.counter >= BULLET_DURATION) {
            this.setDestroyed(true);
        }
        this.counter++;
    }
    
    /**
     * Draws the bullet.
     */
    public void draw() {
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(getPose().getX(), getPose().getY(), BULLET_RADIUS);
    }
    
}