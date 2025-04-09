/**
 * A utility class containg methods for searching through an array.
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 0.1
 */
public class Searcher
{
    /**
     * Search through (part of) a sorted array of int values
     * for a particular target.
     *
     * @param first  The first index to consider (inclusive)
     * @param last   The last index to consider (inclusive)
     * @param target The int value to search for
     * @param data   The sorted array of int value
     * @return       The index of the target (or -1 if it isn't found)
     */ 
    public static int search(int first,  int last, 
                             int target, int[] data)
    {
        int      left, middle, result, right;
        

        result = -1;
        
        if (first == last) // The base case
        {
            if (target == data[first])
            {
                result = first;                
            }
        }
        else              // Refinement (i.e., shrink the search space)
        {
            if ((target >= data[first]) && (target <= data[last]))
            {
                middle = (first + last) / 2;
                left   = search(first, middle, target, data);
                right  = search(middle + 1, last, target, data);
                result = Math.max(left, right);                
            }
        }
        return result;
    }
}