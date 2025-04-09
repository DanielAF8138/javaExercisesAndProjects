

/**
 * This class represents a single customer in a grocery store simulation.
 * 
 * @author Nathan Sprague
 * @version 04/12/2022
 */
public class Customer implements Comparable<Customer> {

    private int numItems;
    private final int enterTime;

    /**
     * Constructs a customer.
     * 
     * @param numItems the number of items this customer has
     * @param startTime the time this customer entered the line
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
     * @return time that the customer started waiting
     */
    public int enterTime() {
        return enterTime;
    }
    
    /**
     * Returns the comparison between customers.
     * 
     * @param o customer
     * @return comaprison
     */
    public int compareTo(Customer o) {
        return (this.numItems() - o.numItems());
    }
    

}
