/**
 * Recursion Exercises
 * 
 * Submit this file to Canvas after testing it with RecursionTest.java
 * You may discuss answers to the questions with others.
 * Solutions may be available in Canvas.
 * 
 * NAMES:
 * 
 */
public class Recursion {
    /**
     * Answer the questions.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {

        // Trace the methods below BY HAND, drawing the activation records and
        // return values. Then answer the questions. Feel free to use Eclipse to
        // check your answers, but only AFTER you have worked through the
        // questions on paper or with a drawing program. Type your answers into
        // this file as comments.

        // 1. What will be printed when the following line of code is executed?
        // olleh
            
        // 2. How many activation records will be created overall?
        // 6
        
        // 3. What is the maximum depth of the resulting call stack?
        // length of string + 1
        
        // 4. Suggest an appropriate name for this function.
        // backwardsPrint
        
        System.out.println(recursiveFunction("hello"));
        
        

        // 5. What will be printed when these two lines of codes are executed?
        // 7
        
        // 6. How many activation records will be created overall?
        // 7
        
        // 7. What is the maximum depth of the resulting call stack?
        // (length of array * 2) - 1
        
        // 8. Suggest an appropriate name for this function.
        // maxNumber
        
        int[] array = {2, 1, 7, 3};
        System.out.println(moreRecursion(array, 0, array.length - 1));
    }

    public static String recursiveFunction(String s) {
        if (s.length() == 0) {
            return "";
        } else {
            String first = s.substring(0, 1); // Just index 0.
            String rest = s.substring(1); // Everything from 1 to the end.
                                          // (Possibly "").
            return recursiveFunction(rest) + first;
        }
    }

    public static int moreRecursion(int[] array, int start, int end) {
        int result;
        if (start == end) {
            result = array[start];
        } else {
            int mid = (start + end) / 2;
            int a = moreRecursion(array, start, mid);
            int b = moreRecursion(array, mid + 1, end);
            if (a > b) {
                result = a;
            } else {
                result = b;
            }
        }
        return result;
    }

    // 9. What's Wrong with the following method? Fix it.

    /**
     * Recursive method for determining if a particular number is stored in an
     * array.
     * 
     * @param first The index in the array where the search should begin.
     * @param array The array to search
     * @param number The number to search for.
     * @return True if the number is in the array, false otherwise
     */
    public static boolean containsNumber(int first, int[] array, int number) {
        if (first >= array.length) {
            return false;
        } else {
            if (array[first] == number) {
                return true;
            }
            return containsNumber(first + 1, array, number);
        }
    }

    // 10. Finish this method.

    /**
     * Reverse the order of the entries in the provided array beginning at index
     * start and ending at index end.
     * 
     * Here are some examples:
     * 
     * <pre>
     * Arguments:      numbers = [32, 43, 9,  8], start = 0, end = 3
     * Final contents of result: [8,  9,  43, 32]
     * 
     * Arguments:      numbers = [32, 43, 9, 8], start = 1, end = 3
     * final contents of result: [32, 8, 9, 43]
     * </pre>
     * 
     * Your solution must be recursive! No loops are allowed.
     * 
     * 
     * @param numbers An array of ints
     * @param start The start index of the region to reverse
     * @param end The end index of the region to reverse
     */
    public static void reverse(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        } 
        int last = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = last;
        reverse(numbers, start + 1, end - 1);
    }

}
