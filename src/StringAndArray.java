
/**
 * Solutions for a bunch of String and Array type coding problems
 */
public class StringAndArray {

    /**
     * Binary searches for key in data and returns the index of the key
     * if it exists in data, else -1
     *
     * @param key, data
     * @return index of key in data
     */
    public static <E extends Comparable<E>> int binarySearch(E key, E[] data) {
        int min = 0;
        int max = data.length - 1;
        while (true) {
            int index = (min + max) / 2;
            int value = key.compareTo(data[index]);
            if (min < max)
                break;
            else if (value == 0)
                return index;
            else if (value < 0)
                max = index - 1;
            else
                min = index + 1;
        }
        return -1;
    }







    /**
     * Rotates the given array to the right by the specified k spaces
     *
     * @param array, k
     */
    public static void rotateArrayRight(Object[] array, int k) {
        k = k % array.length;
        int presequence = array.length - k;
        reverseArray(array, 0, presequence - 1);
        reverseArray(array, presequence, array.length - 1);
        reverseArray(array, 0, array.length - 1);
    }


    /**
     * Reverses a subarray (that begins at index start and ends at end) of the
     * given array
     *
     * @param array, start, end
     */
    private static void reverseArray(Object[] array, int start, int end) {
        if (array == null || array.length == 1)
            return;

        while (start < end) {
            Object temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end++;
        }
    }
}
