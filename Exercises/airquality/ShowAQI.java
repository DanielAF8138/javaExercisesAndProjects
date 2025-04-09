    import java.awt.*;

/**
 * An application that shows air quality index (AQI) information in
 * window.
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class ShowAQI {
    /**
     * The entry-point of the application.
     *
     * @param args  The command-line arguments (
     */
    public static void main(String[] args) {
        AirQuality quality;
        Announcement announcement;        
        int          aqi;        

        
        if ((args == null) || (args.length < 1)) {
            System.out.println("\nUsage: java ShowAQI aqi\n");
        } else {
            aqi = Integer.parseInt(args[0]);
            quality = AirQuality.findAirQuality(aqi);
            
            if (quality == null) {
                System.out.println("\nInvalid AQI. Please try again\n");
            } else {
                // Construct and show the Announcement
                announcement = new Announcement(quality.getDescription(), quality.getColor());
                announcement.setVisible(true);
            }
        }
    }

    
}
