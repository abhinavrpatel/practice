
/**
 * Solutions for a bunch of Sorting type coding problems
 */
public class Sort {

    public static class Link {
        int value;
        Link next = null;

        public int size() {
            if (next == null)
                return 1;
            return 1 + next.size();
        }
    }

    /**
     * Merge sort for a LinkedList into nondescending order
     */
    public static Link mergeSort(Link head) {
        if (head == null || head.next == null)
            return head;

        int middle = head.size() / 2;
        Link left = head;
        Link right = null;
        Link iter = head;
        int counter = 0;
        while (iter != null) {
            counter++;
            Link next = iter.next;
            if (counter == middle) {
                iter.next = null;
                right = next;
                break;
            }
            iter = next;
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }


    private static Link merge(Link left, Link right) {
        Link one = left;
        Link two = right;
        Link anchor = new Link();
        anchor.value = Integer.MAX_VALUE;
        Link iter = anchor;

        while (one != null || two != null) {
            iter.next = new Link();
            if (one == null) {
                iter.next.value = two.value;
                two = two.next;
            } else if (two == null) {
                iter.next.value = one.value;
                one = one.next;
            } else if (one.value < two.value) {
                iter.next.value = one.value;
                one = one.next;
            } else if (one.value > two.value) {
                iter.next.value = two.value;
                two = two.next;
            } else {
                iter.next.value = one.value;
                iter.next.next = new Link();
                iter = iter.next;
                iter.next.value = two.value;
                one = one.next;
                two = two.next;
            }
            iter = iter.next;
        }
        return anchor.next;
    }
}
