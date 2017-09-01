import java.util.*;

/**
 * Solutions for a bunch of Trie and Heap type coding problems
 */
public class TrieAndHeap {

    /**
     * Implement a trie with insert, contains, and startsWith methods.
     */
    public static class Trie {
        private static class TrieNode {
            char value;
            Map<Character, TrieNode> children;
            boolean isWord;

            TrieNode() {
                this.children = new HashMap<>();
            }

            TrieNode(char c) {
                this.children = new HashMap<>();
                this.value = c;
            }
        }


        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            Map<Character, TrieNode> children = root.children;
            for (int i = 0; i < word.length(); i++) {
                char current = word.charAt(i);
                TrieNode node;
                if (children.containsKey(current)) {
                    node = children.get(current);
                } else {
                    node = new TrieNode(current);
                    children.put(current, node);
                }
                children = node.children;

                if (i == word.length() - 1) {
                    node.isWord = true;
                }
            }
        }

        public boolean contains(String word) {
            TrieNode found = findNode(word);
            return found != null && found.isWord;
        }


        /**
         * Returns whether there is any word currently in the Trie that starts with the given prefix
         */
        public boolean startsWith(String prefix) {
            return findNode(prefix) != null;
        }


        private TrieNode findNode(String word) {
            Map<Character, TrieNode> children = root.children;
            TrieNode current = null;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (children.containsKey(c)) {
                    children = children.get(c).children;
                } else {
                    return null;
                }
            }
            return current;
        }
    }









    /**
     * Merge K sorted arrays
     */
    public static Integer[] mergeKSortedArrays(List<Integer[]> arrays) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Integer[] array : arrays)
            for (Integer i : array)
                heap.offer(i);

        Integer[] result = new Integer[heap.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = heap.poll();

        return result;
    }












    private static class Interval {
        int start, end;
    }


    /**
     * Given an array of meeting time intervals consisting of start and end times find the minimum
     * number of conference rooms required.
     */
    public static int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int rooms = 1;
        heap.offer(intervals[0].end);

        for (Interval i : intervals) {
            if (i.start < heap.peek())
                rooms++;
            else
                heap.poll();
            heap.offer(i.end);
        }

        return rooms;
    }
}
