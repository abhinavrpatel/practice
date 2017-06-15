
/**
 * Solutions for a bunch of Dynamic Programming type coding problems
 */
public class DynamicProgramming {

    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move
     * to adjacent numbers on the row below.
     *
     * For example, given the following triangle, the minimum path from top to bottom is 11
     * (2 + 3 + 5 + 1 = 11)
     *
     *  [
     *       [2],
     *      [3,4],
     *     [6,5,7],
     *    [4,1,8,3]
     *  ]
     */
    public static int minimumTotal(int[][] triangle) {
        int len = triangle.length - 1;
        int[] total = new int[triangle[len].length];
        for (int i = 0; i < triangle[len].length; i++)
            total[i] = triangle[len][i];

        for (int i = triangle.length - 2; i >= 0; i--) // y
            for (int j = 0; j < triangle[i + 1].length - 1; j++)
                total[j] = triangle[i][j] + Math.min(total[j], total[j + 1]);
        return total[0];
    }
}
