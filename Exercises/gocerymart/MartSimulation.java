import java.util.ArrayList;
import java.util.Random;

/**
 * This class simulates the checkout activity at a small grocery store, and
 * reports summary statistics.
 * 
 * @author Nathan Sprague
 * @author Chris Mayfield
 * @version 04/12/2022
 */
public class MartSimulation {

    private final double customerChance;
    private final int shiftLength;
    private final int maxItems;

    private int curTime;
    private ArrayList<SortedAisle> aisles;
    private Random generator;

    /**
     * Create a simulation.
     * 
     * @param shiftLength the duration of the simulated shift, in seconds
     * @param customerChance the probability that a new customer starts to
     *     checkout during each time interval
     * @param maxItems the largest number of items that any customer can have
     */
    public MartSimulation(int shiftLength, double customerChance,
            int maxItems) {
        this.shiftLength = shiftLength;
        this.customerChance = customerChance;
        this.maxItems = maxItems;

        this.curTime = 0;
        this.aisles = new ArrayList<SortedAisle>();
        this.generator = new Random();
    }

    /**
     * Add a new aisle to the simulation.
     * 
     * @param aisle The aisle to add
     */
    public void addAisle(Aisle aisle) {
        aisles.add((SortedAisle) aisle);
    }

    /**
     * Helper method that returns the aisle with the shortest line.
     * 
     * @return the aisle with the shortest line
     */
    private SortedAisle shortestAisle() {
        SortedAisle shortest = aisles.get(0);
        for (int i = 1; i < aisles.size(); i++) {
            if (aisles.get(i).lineLength() < shortest.lineLength()) {
                shortest = aisles.get(i);
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

        for (SortedAisle curAisle : aisles) {
            curAisle.step(curTime);
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
     * Gets the random number generator.
     * 
     * @return the random number generator
     */
    public Random getGenerator() {
        return generator;
    }

    /**
     * Return the total number of customers served so far.
     * 
     * @return total customers served
     */
    public int getTotalServed() {
        int total = 0;
        for (SortedAisle curAisle : aisles) {
            total += curAisle.getTotalServed();
        }
        return total;
    }

    /**
     * Return the total number of customers who left so far.
     * 
     * @return total customers who left the store
     */
    public int getTotalLeft() {
        int total = 0;
        for (SortedAisle curAisle : aisles) {
            total += curAisle.getLeftStore();
        }
        return total;
    }

    /**
     * Return the average wait time for all customers served so far.
     * 
     * @return average wait time in seconds
     */
    public double getAverageWait() {
        double totalWait = 0;
        for (SortedAisle curAisle : aisles) {
            totalWait += curAisle.getTotalWait();
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
        for (SortedAisle curAisle : aisles) {
            if (max < curAisle.getMaxWait()) {
                max = curAisle.getMaxWait();
            }
        }
        return max;
    }

    /**
     * Print summary statistics for a complete shift.
     */
    public void printResults() {
        System.out.println("Summary Statics");
        System.out.println("Number of cashiers:      " + aisles.size());
        System.out.println("Shift length:            " + (shiftLength / 60) / 60
                + " hours");
        System.out.println("Total customers served:  " + getTotalServed());
        System.out.println("Total customers left:    " + getTotalLeft());
        System.out.println(
                String.format("Average wait time:       %.2f minutes",
                        getAverageWait() / 60.0));
        System.out.println(String.format(
                "Maximum wait time:       %.2f minutes", getMaxWait() / 60.0));
    }

}
