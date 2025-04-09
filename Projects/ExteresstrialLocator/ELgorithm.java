import java.awt.Point;

/**
 * ELgorithm class.
 * @author fulle2da
 * @version 25/04/2023
 */
public class ELgorithm {
    
    private Sensor sensor;
    
    /**
     * ELgorithm constructor.
     * @param sensor sensor object
     */
    public ELgorithm(Sensor sensor) {
        this.sensor = sensor;
    }
    
    /**
     * search method.
     * @param x x coordinate
     * @param y y coordinate
     * @param width width of search
     * @return point object or null if person is not found
     */
    public Point search(int x, int y, int width) {
        Point result = null;
        // if (sensor.scan(x, y, width) > 0) {
        //    int first, second, third, fourth;
        //    first = sensor.scan(x, y, width / 2);
        //    second = sensor.scan((width / 2) + 1, y, width);
        //    third = sensor.scan(x, (width / 2) + 1, width / 2);
        //    fourth = sensor.scan((width / 2) + 1, (width / 2) + 1, width);        
        // }
        if (sensor.scan(x, y, width) < 0) {
            return null; 
        } else if (sensor.scan(x, y,  width) > 0) {
            int up, down, left, right;
            if (x != sensor.scan(x, y, width)) {
                left = sensor.scan(x, y, width);
                right = sensor.scan((width / 2) + 1, y, width);
            } else {
                up = sensor.scan(x, y, width);
                down = sensor.scan(x, (width / 2) + 1, width);
            }
        }
        
        if (x == width && y == width) {
            result = new Point(x, y);
        }
        
        return result;

    }
}