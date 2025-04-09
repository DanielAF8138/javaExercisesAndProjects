/**
 * GameElement.
 * 
 * @author fulle2da
 * @version 29/03/2023
 */
public abstract class GameElement implements Updatable, Drawable {
    
    protected Pose pose;
    protected Vector2D velocity;
    protected double radius;
    protected boolean destroyed;
    
    /**
     * GameElement Constructor.
     * @param pose positon
     * @param velocity velocity
     * @param radius radius
     */
    public GameElement(Pose pose, Vector2D velocity, double radius) {
        this.pose = pose;
        this.velocity = velocity;
        this.radius = radius;
        this.destroyed = false;
    }
    
    public Pose getPose() {
        return pose;
    }
    
    public Vector2D getVelocity() {
        return velocity;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public boolean isDestroyed() {
        return destroyed;
    }
    
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
    /**
     * Check Collision method.
     * @param other other object
     * @return boolean
     */
    public boolean checkCollision(GameElement other) {
        double posDiff = 0;
        double xCoord = Math.pow(other.getPose().getX() - pose.getX(), 2);
        double yCoord = Math.pow(other.getPose().getY() - pose.getY(), 2);
        posDiff = Math.sqrt(xCoord + yCoord);
        return (posDiff <= (radius + other.radius));
    }    
    
    /**
     * update interface.
     */
    public void update() {
        this.pose = this.pose.move(velocity);
        if (pose.getX() > GameDriver.SCREEN_WIDTH) {
            this.pose = this.pose.newX(0);
        } else if (pose.getX() < 0) {
            this.pose = this.pose.newX(GameDriver.SCREEN_WIDTH);
        }
        if (pose.getY() > GameDriver.SCREEN_HEIGHT) {
            this.pose = this.pose.newY(0);
        } else if (pose.getY() < 0) {
            this.pose = this.pose.newY(GameDriver.SCREEN_HEIGHT);
        } 
        
    }
    
    /**
     * draw interface.
     */
    public abstract void draw();
    
}
