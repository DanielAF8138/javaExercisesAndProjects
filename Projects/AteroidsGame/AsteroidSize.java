/**
 * AsteroidSize enum.
 * @author fulle2da
 * @version 14/04/2023
 */
public enum AsteroidSize {
    SMALL(10, 200),
    MEDIUM(20, 100),
    LARGE(30, 50);
    
    private int radius;
    private int points;
    
    /**
     * AsteroidSize constructor.
     * @param radius radius
     * @param points points
     */
    private AsteroidSize(int radius, int points) {
        this.radius = radius;
        this.points = points;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public int getPoints() {
        return points;
    }
    
    /**
     * randomSize method.
     * @return enum
     */
    public static AsteroidSize randomSize() {
        int probability = GameDriver.GENERATOR.nextInt(20);
        if (probability < 10) {
            return LARGE;
        } else if (probability > 9 && probability < 15) {
            return MEDIUM;
        } else {
            return SMALL;
        }
    }
}
