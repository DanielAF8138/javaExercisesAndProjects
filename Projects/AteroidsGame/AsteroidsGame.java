import java.util.ArrayList;

/**
 * Main class for Asteroids.
 * 
 * @author CS159 Instructors
 * @version s23
 */
public class AsteroidsGame implements Playable {

    public static final int LIVES = 3;
    
    private ArrayList<Drawable> drawElements;
    private ArrayList<Updatable> updateElements;
    private ArrayList<GameElement> shipAndBullets;
    private ArrayList<Enemy> enemies;
    
    private Ship ship;

    private NumericDisplay score;
    private NumericDisplay lives;
    

    /**
     * Constructs all game elements.
     */
    public AsteroidsGame() {
        StdDraw.setTitle("Generic Space Rock Shooter");
        
        drawElements = new ArrayList<>();
        updateElements = new ArrayList<>();
        shipAndBullets = new ArrayList<>();
        enemies = new ArrayList<>();

        // add background elements
        final int TOP = GameDriver.SCREEN_HEIGHT;
        score = new NumericDisplay(10, TOP - 20, "Score: ", 0);
        lives = new NumericDisplay(10, TOP - 40, "Lives: ", LIVES);
        drawElements.add(score);
        drawElements.add(lives);

        // TODO
    }

    /**
     * Creates and adds 100 stars with random locations.
     */
    private void newStars() {
        for (int i = 0; i < 100; i++) {
            Star star = new Star(randomXPosition(), randomYPosition());
            drawElements.add(star);
        }
    }
    
    /**
     * newShip method.
     */
    private void newShip() {
        this.ship = new Ship();
        shipAndBullets.add(ship);
        drawElements.add(ship);
        updateElements.add(ship);
    }
    
    /**
     * addEnemy method.
     * @param enemy enemy
     */
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        drawElements.add(enemy);
        updateElements.add(enemy);
    }
    
    /**
     * newEnemies method.
     */
    private void newEnemies() {
        for (int i = 0; i < 10; i++) {
            Asteroid asteroid = new Asteroid(AsteroidSize.randomSize());
            addEnemy(asteroid);
        }
    }
    
    /**
     * Starts a new game with 10 asteroids.
     */
    public void startGame() {
        newStars();
        newShip();
        newEnemies();
    }
    
    /**
     * handleCollisions method.
     */
    public void handleCollisions() {
        for (Enemy e: enemies) {
            for (GameElement b: shipAndBullets) {      
                if  (e.checkCollision(b)) {
                    e.setDestroyed(true);
                    b.setDestroyed(true);
                }
            }
        }
    }
    
    /**
     * removeDestroyedBullets method.
     */
    public void removeDestroyedBullets() {
        for (int i = shipAndBullets.size() - 1; i > -1; i--) {
            GameElement b = shipAndBullets.get(i);
            if (b instanceof Bullet) {
                if (b.isDestroyed()) {
                    drawElements.remove(b);
                    updateElements.remove(b);
                    shipAndBullets.remove(b);
                }
            }
            if (b instanceof Ship) {
                if (b.isDestroyed()) {
                    drawElements.remove(b);
                    updateElements.remove(b);
                    shipAndBullets.remove(b);
                    newShip();
                    lives.setValue(lives.getValue() - 1);
                }
            }
                
               
            
        }
    }
    
    /**
     * removeDestroyedEnemies method.
     */
    public void removeDestroyedEnemies() {
        for (int i = enemies.size() - 1; i > -1; i--) {
            Enemy e = enemies.get(i);
            if (e.isDestroyed()) {
                score.setValue(score.getValue() + e.getPoints()); 
                drawElements.remove(e);
                updateElements.remove(e);
                enemies.remove(e);
            }
        }
    }
    
    /**
     * Handle keyboard input from the game and move the ship and shoot bullets
     * if the corresponding keys are pressed.
     */
    private void handleKeyboardInput() {
        if (GameDriver.spacePressed()) {
            // TODO
            Bullet bullet = new Bullet(ship.getPose());
            shipAndBullets.add(bullet);
            drawElements.add(bullet);
            updateElements.add(bullet);
        }
        
        if (GameDriver.leftPressed()) {
            // TODO
            ship.turnLeft();
        }
        
        if (GameDriver.rightPressed()) {
            // TODO
            ship.turnRight();
        }
        
        if (GameDriver.upPressed()) {
            // TODO
            ship.thrust();
        }
    }
    
    @Override
    public void update() {
        // freeze simulation if game is over
        if (lives.getValue() <= 0) {
            return;
        }
        
        // update everything (including newest bullet)
        handleKeyboardInput();
        for (Updatable item : updateElements) {
            item.update();
        }

        // TODO You will need these in Part 3
        handleCollisions();
        removeDestroyedBullets();
        removeDestroyedEnemies();

        // TODO Put your code here
        boolean probability = GameDriver.GENERATOR.nextDouble() <= Saucer.SPAWN_PROB;
        if (probability) {
            Saucer saucer = new Saucer();
            addEnemy(saucer);
        }
        
        if (enemies.size() == 0) {
            newEnemies();
        }
    }
     
    /**
     * draw interface.
     */
    @Override
    public void draw() {
        // TODO
        StdDraw.setPenColor(255, 255, 255);
        for (Drawable item : drawElements) {
            item.draw();
        }
    }
    

    /**
     * Generates a random X position on the screen.
     * 
     * @return the x position
     */
    protected static double randomXPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_WIDTH;
    }

    /**
     * Generates a random Y position on the screen.
     * 
     * @return the y position
     */
    protected static double randomYPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_HEIGHT;
    }

    /**
     * Generates a random heading from the interval [0, 2*PI).
     * 
     * @return the heading
     */
    protected static double randomHeading() {
        return GameDriver.GENERATOR.nextDouble() * 2 * Math.PI;
    }

}
