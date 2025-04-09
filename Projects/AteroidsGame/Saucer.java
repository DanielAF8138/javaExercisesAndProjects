/**
 * Saucer class.
 * @author fulle2da
 * @version 14/04/2023
 */
public class Saucer extends Enemy {
    
    public static final int HALF_WIDTH = 10;
    public static final int HALF_HEIGHT = 5;
    public static final int SAUCER_SPEED = 2;
    public static final int SAUCER_POINTS = 400;
    public static final double SPAWN_PROB = 0.002;
    public static final double TURN_PROB = 0.05;
    
    /**
     * Saucer constructor.
     */
    public Saucer() {
        super(SAUCER_SPEED, HALF_WIDTH, SAUCER_POINTS);
    }
    
    /**
     * update interface.
     */
    @Override
    public void update() {
        this.pose = this.pose.move(velocity);
        boolean probability = GameDriver.GENERATOR.nextDouble() <= TURN_PROB;
        if (probability) {
            this.velocity = this.velocity.newHeading(AsteroidsGame.randomHeading());
        }
        if (pose.getX() > GameDriver.SCREEN_WIDTH) {
            setDestroyed(true);
        } else if (pose.getX() < 0) {
            setDestroyed(true);
        }
        if (pose.getY() > GameDriver.SCREEN_HEIGHT) {
            setDestroyed(true);
        } else if (pose.getY() < 0) {
            setDestroyed(true);
        } 
    }
    
    /**
     * draw interface.
     */
    public void draw() {
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.rectangle(getPose().getX(), getPose().getY(), HALF_WIDTH, HALF_HEIGHT);
    }
}