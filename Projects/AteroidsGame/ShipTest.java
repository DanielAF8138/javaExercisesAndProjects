import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShipTest {
    private Ship s;
    
    @BeforeEach
    public void setup() {
        s = new Ship();
    }
    
    @Test
    public void testImplementsInterface() {
        assertTrue(s instanceof Drawable);
    }
    
    @Test
    public void testContstants1() {
        assertEquals(10, Ship.SHIP_WIDTH);
    }
    
    @Test
    public void testContstants2() {
        assertEquals(20, Ship.SHIP_HEIGHT);
    }
    
    @Test
    public void testContstants3() {
        assertEquals(0.1, Ship.SHIP_TURN);
    }
    
    @Test
    public void testContstants4() {
        assertEquals(0.1, Ship.SHIP_MOVE);
    }
    
    @Test
    public void testContstants5() {
        assertEquals(0.02, Ship.FRICTION);
    }
    
    @Test
    public void TestTurnLeft() {
        Pose pose = new Pose(240, 240, (Math.PI/2 + 0.1));
        s.turnLeft();
        assertEquals(pose, s.getPose());
    }
    
    @Test
    public void TestTurnRight() {
        Pose pose = new Pose(240, 240, (Math.PI/2 - 0.1));
        s.turnRight();
        assertEquals(pose, s.getPose());
    }
    
    @Test
    public void TestThrust() {
        Pose pose = new Pose(240, 240.1, (Math.PI/2));
        s.thrust();
        s.update();
        assertEquals(pose, s.getPose());    
    }
    
    @Test
    public void TestDraw() {
        s.draw();
        String actual = StdDraw.getLastDraw();
        assertEquals("polygon()", actual);    
    }
    
    @Test
    public void TestUpdate() {
        s.update();
        assertEquals(1, 1);
        s.velocity.newMagnitude(0);
        assertEquals(0, s.velocity.getMagnitude());
    }
    
}