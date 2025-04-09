import java.util.Random;

/**
 * This class simulates the checkout activity at a small grocery store, and reports summary statistics.
 * 
 * @author Nathan Sprague
 * @version 22/02/2023
 * 
 */
public class MartSimulation {
    private final double customerChance;
    private final int shiftLength;
    private final int numAisles;
    private final int maxItems;
    private final int maxCustomer;

    private int curTime;
    private Aisle[] aisles;
    private Random generator;

    /**
     * Create a simulation.
     * 
     * @param shiftLength the duration of the simulated shift, in seconds
     * @param numAisles the number of open aisles in the simulation
     * @param customerChance the probability that a new customer starts to checkout during each time interval
     * @param maxItems the largest number of items that any customer can arrive with
     * @param maxCustomer the max customers per line
     */
    public MartSimulation(int shiftLength, int numAisles, double customerChance, int maxItems, int maxCustomer) {
        this.shiftLength = shiftLength;
        this.numAisles = numAisles;
        this.customerChance = customerChance;
        this.maxItems = maxItems;
        this.maxCustomer = maxCustomer;

        this.curTime = 0;
        this.generator = new Random();

        aisles = new Aisle[numAisles];

        for (int i = 0; i < numAisles; i++) {
            aisles[i] = new Aisle(generator);
        }
    }

    /**
     * Helper method that returns the aisle with the shortest line.
     * 
     * @return The aisle with the shortest line.
     */
    private Aisle shortestAisle() {
        Aisle shortest = aisles[0];
        for (int i = 1; i < numAisles; i++) {
            if (aisles[i].lineLength() < shortest.lineLength()) {
                shortest = aisles[i];
            }
        }
        return shortest;
    }

    /**
     * Perform one step of the simulation.
     */
    public void step() {
        double customerRand = generator.nextDouble();

        if (customerRand < customerChance) {
            int numItems = generator.nextInt(maxItems + 1);
            Customer customer = new Customer(numItems, curTime);
            shortestAisle().addCustomer(customer);
        }

        for (int i = 0; i < numAisles; i++) {
            aisles[i].step(curTime);
        }

        curTime++;
    }

    /**
     * Run the simulation through an entire shift.
     */
    public void runSimulation() {
        while (curTime < shiftLength) {
            step();
        }
    }

    /**
     * Return the total number of customers served so far.
     * 
     * @return total customers served
     */
    public int getTotalServed() {
        int total = 0;
        for (int i = 0; i < numAisles; i++) {
            total += aisles[i].getTotalServed();
        }
        return total;
    }

    /**
     * Return the average wait time for all customers that have been served so far.
     * 
     * @return average wait time in seconds
     */
    public double getAverageWait() {
        double totalWait = 0;
        for (int i = 0; i < numAisles; i++) {
            totalWait += aisles[i].getTotalWait();
        }
        return totalWait / getTotalServed();
    }

    /**
     * Return the longest wait time for any customer so far.
     * 
     * @return the longest wait time in seconds
     */
    public int getMaxWait() {
        int max = 0;
        for (int i = 0; i < numAisles; i++) {
            if (max < aisles[i].getMaxWait()) {
                max = aisles[i].getMaxWait();
            }
        }
        return max;
    }

    /**
     * Print summary statistics for a complete shift.
     */
    public void printResults() {
        System.out.println("Summary Statics");
        System.out.println("Number of cashiers:      " + numAisles);
        System.out.println("Shift length:            " + (shiftLength / 60) / 60 + " hours");
        System.out.println("Total customers served:  " + getTotalServed());
        System.out.println(String.format("Average wait time:       %.2f minutes", getAverageWait() / 60.0));
        System.out.println(String.format("Maximum wait time:       %.2f minutes", getMaxWait() / 60.0));
    }

}
