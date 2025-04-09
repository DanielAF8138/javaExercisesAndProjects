import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BulletTest {
    private Bullet b;
    private Ship s;
    
    @BeforeEach 
    public void setUp() {
        s = new Ship();
        b = new Bullet(s.getPose());
    }
    
    @Test
    public void TestConstants() {
        assertEquals(1.5, Bullet.BULLET_RADIUS);
        assertEquals(20, Bullet.BULLET_SPEED);
        assertEquals(20, Bullet.BULLET_DURATION);
    }
    
    @Test
    public void TestBullet() {
        assertEquals(s.getPose(), b.getPose());
    }
    
    @Test
    public void TestUpdate() {
        Pose pose = new Pose(240, 240, Math.PI/2);
        b.update();
        assertEquals(pose, b.getPose());
        for (int i = 0; i < 20; i++) {
            b.update();
        }
        Pose pose2 = new Pose(240, 240, Math.PI/2);
        assertEquals(pose2, b.getPose());
    }
    
    @Test
    public void TestDraw() {
        b.draw();
        
        String actual = StdDraw.getLastDraw();
        assertEquals("filledCircle(240.0, 240.0, 1.5)", actual);
        
    }
}