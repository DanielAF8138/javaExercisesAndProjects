import java.util.Random;
import java.util.Scanner;
/**
 * Driver class for the grocery store simulation.
 * 
 * @author Nathan Sprague
 * @version 04/12/2022
 */

public class MartDriver {

    /**
     * Run the simulation and display the results.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int totalSeconds = 8 * 60 * 60;  // 8 hours
        int numCashiers = 8;
        double customerProbability = .05;
        int maxItems = 100;
        int maxLength = 20;

        // UNCOMMENT TO COMPLETE THE LAST PART OF THE LAB
        System.out.println("What aisle type should be used?");
        System.out.println(" 1 - Simple");
        System.out.println(" 2 - Limited");
        System.out.println(" 3 - Sorted");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        in.close();
        

        MartSimulation sim = new MartSimulation(totalSeconds,
                customerProbability, maxItems);
        Random gen = sim.getGenerator();
        switch (type) {
            case 1:
                for (int i = 0; i < numCashiers; i++) {
                    sim.addAisle(new Aisle(gen));
                }
                break;
            case 2:
                for (int i = 0; i < numCashiers; i++) {
                    sim.addAisle(new LimitedAisle(gen, maxLength));
                }
                break;
            case 3:
                for (int i = 0; i < numCashiers; i++) {
                    sim.addAisle(new SortedAisle(gen, maxLength));
                }
                break;
            default:
                System.out.println("Invalid input. Using SortedAisle.");
                for (int i = 0; i < numCashiers; i++) {
                    sim.addAisle(new SortedAisle(gen, maxLength));
                }
                break;
        }
        sim.runSimulation();
        sim.printResults();
    }

}
