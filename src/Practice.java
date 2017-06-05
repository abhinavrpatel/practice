
public class Practice {

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
}
