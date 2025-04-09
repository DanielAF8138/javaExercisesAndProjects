import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Exercises for practicing with Java collection types.
 * 
 * @author fulle2da
 * @version 12/04/23
 */
public class CollectionExercises {

    /**
     * This method removes all values from the provided list that are smaller
     * than the indicated integer. The remaining elements retain their original
     * ordering.
     * 
     * @param list the list of integers
     * @param minVal the minimum value to retain
     */
    public static void removeSmallInts(List<Integer> list, int minVal) {
        // Your solution must use an iterator. Conveniently, the list iterator
        // has a remove method.
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            if (i.next() < minVal) {
                i.remove();
            }
        }
    }

    /**
     * This method returns true if the provided collection contains any
     * duplicate elements.
     * 
     * @param ints a collection of integers
     * @return true if ints contains duplicates, false otherwise
     */
    public static boolean containsDuplicates(Collection<Integer> ints) {
        // Your solution should not use any loops.
        HashSet<Integer> set = new HashSet<Integer>(ints);
        return (set.size() < ints.size());
    }

    /**
     * This method returns an ArrayList containing all elements that appear in
     * either of the two collection arguments. There will be no duplicate values
     * in the resulting ArrayList. The values in the returned ArrayList may be
     * in any order.
     * 
     * For example, if the two arguments contain {2, 1, 2, 3} and {3, 4, 4, 5},
     * the returned ArrayList will contain {1, 2, 3, 4, 5}. The original
     * collections will not be modified.
     * 
     * @param ints1 the first collection
     * @param ints2 the second collection
     * @return An ArrayList containing the integers that appear in either
     *     collection.
     */
    public static ArrayList<Integer> inEither(Collection<Integer> ints1,
            Collection<Integer> ints2) {
        // This can be done with no loops.
        ints1.addAll(ints2);
        HashSet<Integer> set = new HashSet<Integer>(ints1);
        return new ArrayList<Integer>(set);
    }

    /**
     * This method returns an ArrayList containing all elements that appear in
     * both of the two collection arguments. There will be no duplicate values
     * in the resulting ArrayList. The values in the returned ArrayList may be
     * in any order. For example, if the two arguments contain {2, 1, 2, 3} and
     * {3, 4, 4, 5}, the returned ArrayList will contain {3}. The original
     * collections will not be modified.
     * 
     * @param ints1 the first collection
     * @param ints2 the second collection
     * @return An ArrayList containing the integers that appear in both
     *     collections.
     */
    public static ArrayList<Integer> inBoth(Collection<Integer> ints1,
            Collection<Integer> ints2) {
        ints1.retainAll(ints2);
        HashSet<Integer> set = new HashSet<Integer>(ints1);
        return new ArrayList<Integer>(set);
    }

    /**
     * This method returns the String that appears most frequently in the
     * provided list. For example, if the input list contains the elements
     * {"Bob", "Alice", "Bob"}, this method will return "Bob". If there are
     * ties, any of the most frequently occurring elements may be returned.
     * 
     * @param list a list of Strings
     * @return the most frequently occurring String
     */
    public static String mostFrequent(List<String> list) {
        // You should solve this problem in two stages: First iterate through
        // the list to count every String. Then iterate through your counts
        // to find the largest. You'll need a collection that allows you to
        // store a mapping from Strings to counts.
        // Remember: no nested for-loops are allowed.
        
        Map<String, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        String mostFrequentString = null;

        for (String s : list) {
            int count = countMap.getOrDefault(s, 0) + 1;
            countMap.put(s, count);
            if (count > maxCount) {
                maxCount = count;
                mostFrequentString = s;
            }
        }

        return mostFrequentString;
    }

}
