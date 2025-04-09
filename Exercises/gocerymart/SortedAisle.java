import java.util.Random;

/**
 * SortedAisle, sorts line.
 * @author fulle2da
 * @version 27/03/2023
 */
public class SortedAisle extends Aisle {
    private int maxLength;
    
    /**
     * SortedAisle.
     * @param generator generator
     */
    public SortedAisle(Random generator) {
        super(generator);
        this.line = super.line;
    }
    
    /**
     * SortedAisle constructor 2.
     * @param generator generator
     * @param maxLength maxlength
     */
    public SortedAisle(Random generator, int maxLength) {
        super(generator);
        this.maxLength = maxLength;
    }
    
    /**
     * Adds a customer to the line. 
     * 
     * @param customer customer
     */
    public void addCustomer(Customer customer) {
        super.addCustomer(customer);
        super.line.sort(null);
    }
    
    /**
     * Amount that left the store.
     * 
     * @return 0 int 0;
     */
    public int getLeftStore() {
        return 0;
    }
}