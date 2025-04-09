import java.util.Random;

/**
 * LimitedAisle subclass.
 * 
 * @author fulle2da
 * @version 22/02/2023
 *
 */
public class LimitedAisle extends Aisle {
    private final int maxCustomer;
    private int customersLeft;

    /**
     * Constructor.
     * 
     * @param generator generator
     */
    public LimitedAisle(Random generator) {
        super(generator);
        customersLeft = 0;
        maxCustomer = 0;
    }

    /**
     * overrides addcustomer.
     * 
     * @param customer customer
     */
    public void addCustomer(Customer customer) {
        if (super.lineLength() > maxCustomer) {
            customersLeft++;
        } else {
            super.addCustomer(customer);
        }
    }
}