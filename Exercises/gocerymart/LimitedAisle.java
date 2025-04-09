import java.util.Random;

/**
 * An Aisle that has a maximum capacity.
 * 
 * @author Chris Mayfield
 * @version 04/12/2022
 */
public class LimitedAisle extends Aisle {

    private int maxLength;
    private int leftStore;

    /**
     * Construct an empty aisle (no customers).
     * 
     * @param generator random number generator
     * @param maxLength capacity of the aisle
     */
    public LimitedAisle(Random generator, int maxLength) {
        super(generator);
        this.maxLength = maxLength;
        this.leftStore = 0;
    }

    /**
     * Add a new customer to the back of the line. New customers are added only
     * if the line is below some maximum capacity. Otherwise they leave, and the
     * count is incremented.
     * 
     * @param customer the new customer
     */
    public void addCustomer(Customer customer) {
        if (lineLength() < maxLength) {
            super.addCustomer(customer);
        } else {
            leftStore++;
        }
    }

    /**
     * Gets the maximum length.
     * 
     * @return capacity of the aisle
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Gets the number who left the store.
     * 
     * @return customer count
     */
    public int getLeftStore() {
        return leftStore;
    }

}

// How many customers depart (using 8 cashiers) when maximum line length is...
// 
//  1: about 483
//  5: about 264
// 20: about 145
