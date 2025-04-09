/**
 * Ship class.
 * @author fulle2da
 * @version 9/03/2023
 */
public class Ship extends GameElement {
    
    public static final int SHIP_WIDTH = 10;
    public static final int SHIP_HEIGHT = 20;
    public static final double SHIP_TURN = 0.1;
    public static final double SHIP_MOVE = 0.1;
    public static final double FRICTION = 0.02;
    
    /**
     * Ship constructor.
     */
    public Ship() {
        super(new Pose(240, 240, Math.PI / 2), new Vector2D(0, 0), SHIP_HEIGHT / 2);
    }
    
    /**
     * Turns the ship left.
     */
    public void turnLeft() {
        this.pose = pose.newHeading(super.getPose().getHeading() + SHIP_TURN);
    }
    
    /**
     * Turns the ship right.
     */
    public void turnRight() {
        this.pose = pose.newHeading(super.getPose().getHeading() - SHIP_TURN);
    }
    
    /**
     * Moves the ship forward.
     */
    public void thrust() {
        Vector2D thrust = new Vector2D(pose.getHeading(), SHIP_MOVE);
        this.velocity = velocity.add(thrust);
    }
    
    /**
     * Draws the ship.
     */
    public void draw() {
        GameUtils.drawPoseAsTriangle(pose, SHIP_WIDTH, SHIP_HEIGHT);
    }
    
    /**
     * Updates the ships position.
     */
    public void update() {
        super.update();
        if ((velocity.getMagnitude() - FRICTION) < 0) {
            this.velocity = velocity.newMagnitude(0); 
        } else {
            this.velocity = velocity.newMagnitude(velocity.getMagnitude() - FRICTION);
        }
    }  
}