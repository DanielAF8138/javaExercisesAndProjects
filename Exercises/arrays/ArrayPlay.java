/**
 * class ArrayPlay.
 * 
 * @author fulle2da
 * @version 03/02/2023
 */
public class ArrayPlay {
    /**
     * main.
     * 
     * @param args args
     */
    public static void main(String[] args) {
        int[] a = new int[6];
        for (int i = 0; i < a.length; i++)
            a[i] = -1;

        printArray(a);

        for (int i = 0; i < a.length; i++)
            a[i] = i;

        printArray(a);

        for (int i = 0; i < a.length; i++)
            a[i] = 0;

        System.out.println("Array Play");

        Die d1 = new Die();
        for (int i = 0; i < 100; i++) {
            d1.roll();
            int roll = d1.getFace();
            a[roll - 1]++;
        }

        for (int i = 0; i < a.length; i++)
            System.out.println(String.format("%d was rolled %d times.\n", i + 1, a[i]));

        double[] minogue;
        minogue = new double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 };
        double[] oLeary = new double[10];

        System.out.println("Before");

        printArray(minogue, oLeary);

        for (int i = 0; i < oLeary.length; i++)
            oLeary[i] += i;

        System.out.println("After");

        printArray(minogue, oLeary);

        minogue[0] = 99.0;
        oLeary[5] = 99.0;

        System.out.println("After Change");

        printArray(minogue, oLeary);

    }

    /**
     * printArray.
     * 
     * @param a array input
     */
    public static void printArray(int[] a) {
        if (a == null) {
            System.out.println("null");
        } else {
            for (int i = 0; i < a.length; i++)
                System.out.println(String.format("array[%d] = %d", i, a[i]));

        }

    }

    /**
     * formMessage.
     * 
     * @param a array input
     * @param index index input
     * @param format message format
     * @return string
     */
    public static String formMessage(int[] a, int index, String format) {
        if (a == null) {
            return "null";
        } else if (index >= a.length || index < 0) {
            return "index out of bounds";
        } else {
            return String.format(format, index, a[index]);
        }
    }

    /**
     * printArray.
     * 
     * @param a array1 input
     * @param b array2 input
     */
    public static void printArray(double[] a, double[] b) {
        if (a == null || b == null) {
            System.out.println("null");
        } else {
            for (int i = 0; i < b.length; i++)
                System.out.println(i + " A1 = " + a[i] + " A2 = " + b[i]);

        }
    }

}