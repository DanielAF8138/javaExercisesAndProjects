/**
 * Driver class for the grocery store simulation.
 * 
 * @author Nathan Sprague
 *
 */
public class MartDriver {

    /**
     * Run the simulation and display the results.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        int totalSeconds = 8 * 60 * 60; // 8 hours.
        int numCashiers = 12;
        double customerProbability = .05;
        int maxItems = 100;

        MartSimulation sim = new MartSimulation(totalSeconds, numCashiers, customerProbability, maxItems);

        sim.runSimulation();
        sim.printResults();

    }

}
