import java.awt.Point;

/**
 * An application that can be used to locate an extraterrestrial.
 * 
 * @author Prof. David Bernstein, James Madison Universuty
 * @version 1.0
 */
public class ExtraterrestrialLocator {

    /**
     * The entry point of the application.
     * 
     * args[0] contains the name of the extraterrestrial to locate.
     * args[1] contains the option scantime in milliseconds
     * 
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        ELgorithm el;
        int scanTime;
        Point result;
        Sensor sensor;

        if ((args == null) || (args.length == 0)) {
            System.out.println("You didn't tell me what extraterrestrial to locate.");
            System.out.println("Please use the following syntax: ");
            System.out.println("     ExtraterrestrialLocator et [scantime]");
            System.out.println("where the scantime is in milliseconds.");
        } else {
            scanTime = 0;

            if (args.length > 1) {
                try {
                    scanTime = Integer.parseInt(args[1]);
                } catch (NumberFormatException nfe) {
                    scanTime = 1000; // 1000 milliseconds (i.e., 1 second)
                }
            }

            sensor = new Sensor(args[0], scanTime);

            el = new ELgorithm(sensor);
            result = el.search(0, 0, 512);

            System.out.print("Extraterrestrial " + args[0] + " ");
            if (result == null)
                System.out.println("not located.");
            else
                System.out.println("located at " + result.x + "," + result.y);
            System.out.println("");
            System.out.println(sensor.checkSystem());
        }
    }
}
