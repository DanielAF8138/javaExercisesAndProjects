/**
 * Enemy Interface.
 * @author fulle2da
 * @version 14/04/2023
 */
public abstract class Enemy extends GameElement {
    
    protected int points;
    
    /**
     * Enemy Constructor.
     * @param speed speed
     * @param radius radius
     * @param points points
     */
    public Enemy(double speed, double radius, int points) {
        super(new Pose(AsteroidsGame.randomXPosition(), AsteroidsGame.randomYPosition(), AsteroidsGame.randomHeading()),
                new Vector2D(AsteroidsGame.randomHeading(), speed), radius);
        this.points = points;
    }
    
    public int getPoints() {
        return points;
    }
    
}