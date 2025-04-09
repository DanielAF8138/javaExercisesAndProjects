/**
 * This class represents a single customer in a grocery store simulation.
 * 
 * @author Nathan Sprague
 */
public class Customer {
    private int numItems;
    private final int enterTime;

    /**
     * Create a customer.
     * 
     * @param numItems The number of items this customer enters the line with
     * @param startTime The time this customer entered the line
     */
    public Customer(int numItems, int startTime) {
        this.numItems = numItems;
        this.enterTime = startTime;
    }

    /**
     * Return the number of items that still need to be scanned.
     * 
     * @return number of remaining items
     */
    public int numItems() {
        return numItems;
    }

    /**
     * Return the time that this customer entered the aisle.
     * 
     * @return time that the customer started waiting.
     */
    public int enterTime() {
        return enterTime;
    }

}
