/**
 * class Car.
 * 
 * @author fulle2da
 * @version 26/01/2023
 * 
 */
public class Car {
    private String make;
    private int year;
    private double speed;

    /**
     * Car constructor.
     * 
     * @param m make
     * @param y year
     */
    public Car(String m, int y) {
        this.make = m;
        this.year = y;
        this.speed = 0;

    }

    /**
     * Writes the string for the make year and speed of the car.
     * 
     * @return returns expected sentence
     */
    public String toString() {
        return String.format("A %d %s that is going %.1f mph", year, make, speed);

    }

    public String getMake() {
        return make;

    }

    public double getSpeed() {
        return speed;

    }

    public int getYear() {
        return year;

    }

    /**
     * Accelerate the car.
     * 
     * @return returns the expected string
     */
    public String accelerate() {
        double increase = 5.0;
        double temp = speed;
        if (speed + increase > 150) {
            increase = 0;
        }
        speed += increase;
        return String.format("%.1f + %.1f = %.1f", temp, increase, speed);

    }

    /**
     * Brakes the car and removes the acceleration.
     */
    public void brake() {
        if (speed >= 5) {
            speed -= 5;
        }
    }
}