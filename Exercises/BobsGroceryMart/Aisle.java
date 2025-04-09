import java.util.ArrayList;
import java.util.Random;

/**
 * This class simulates a single staffed aisle in a grocery store.
 * 
 * @author Nathan Sprague
 * 
 */
public class Aisle {
    public static final int MAX_BAG_TIME = 5;

    private Random generator;
    private ArrayList<Customer> line;
    private int totalServed;
    private int totalWait;
    private int maxWait;

    private int numItemsOnBelt;
    private int itemStart;
    private int itemDelay;

    /**
     * Construct an empty aisle (no customers).
     */
    public Aisle(Random generator) {
        this.generator = generator;
        line = new ArrayList<Customer>();

        totalServed = 0;
        totalWait = 0;
        numItemsOnBelt = 0;

        // These will only be accessed when there are items on the belt.
        itemStart = -1;
        itemDelay = -1;
    }

    /**
     * Returns the number of customers at this aisle. The customer currently
     * being checked out is included in the total.
     * 
     * @return number of customers waiting
     */
    public int lineLength() {
        int result = line.size();
        if (numItemsOnBelt > 0) {
            result++;
        }
        return result;
    }

    /**
     * Add a new customer to the back of the line.
     * 
     * @param customer the new customer
     */
    public void addCustomer(Customer customer) {
        line.add(customer);
    }

    /**
     * This method removes the next customer from the line, and places all of
     * their items on the belt: the customer is done waiting, and is now in the
     * process of being checked out. The method also updates statistics
     * according to the wait time of the customer that just finished waiting.
     * 
     * @param curTime The clock time of this event
     */
    private void nextCustomer(int curTime) {
        Customer curCustomer;

        curCustomer = line.remove(0);
        numItemsOnBelt = curCustomer.numItems();
        int waitTime = curTime - curCustomer.enterTime();
        totalServed++;
        totalWait += waitTime;
        if (waitTime > maxWait) {
            maxWait = waitTime;
        }
    }

    /**
     * Initialize the process of bagging the next item. We determine how long it
     * will take to bag this item, and record the start time.
     * 
     * @param curTime The current clock time
     */
    private void nextItem(int curTime) {
        itemStart = curTime;
        itemDelay = generator.nextInt(MAX_BAG_TIME) + 1;
    }

    /**
     * Process one simulation step.
     * 
     * @param curTime the current simulation time.
     */
    public void step(int curTime) {

        // Start checking out the next customer, if necessary.
        if (numItemsOnBelt == 0 && !line.isEmpty()) {
            nextCustomer(curTime);
            nextItem(curTime);
        }

        // Work on bagging the current item, if necessary.
        if (numItemsOnBelt > 0) {
            if (curTime > itemStart + itemDelay) {
                numItemsOnBelt--;
                nextItem(curTime);
            }
        }

    }

    /**
     * Return the total number of customers served so far at this aisle.
     * 
     * @return number of customers served
     */
    public int getTotalServed() {
        return totalServed;
    }

    /**
     * Return the total wait time for all customers so far in this aisle.
     * 
     * @return total wait time so far
     */
    public int getTotalWait() {
        return totalWait;
    }

    /**
     * Return the maximum wait time for any customer so far.
     * 
     * @return maximum wait time so far
     */
    public int getMaxWait() {
        return maxWait;
    }

}
