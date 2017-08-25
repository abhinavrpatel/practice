import java.util.ArrayList;
import java.util.List;

/**
 * Solutions for a bunch of Matrix type coding problems
 */
public class Matrix {
    /**
     * Given a m * n matrix, if an element is 0, set its entire row and column to 0 (in place).
     */
    public static void setZeros(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int[] arr : matrix) {
            if (arr[0] != 0)
                continue;
            firstColZero = true;
            break;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] != 0)
                continue;
            firstRowZero = true;
            break;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }






    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix
     * in spiral order.
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (result.size() < m * n) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (bottom < top) break; // no duplicate rows

            for (int i = right; i >= left; right--) {
                result.add(matrix[bottom][i]);
            }
            left++;
        }

        return result;
    }






    /**
     * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in
     * spiral order
     */
    public static int[][] generateSpiralOrder(int n) {
        int[][] result = new int[n][n];
        int size = n * n;

        int value = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (value < size) {
            for (int i = left; i <= right; i++) {
                result[top][i] = value;
                value++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = value;
                value++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                result[bottom][i] = value;
                value++;
            }
            bottom--;

            for (int i = bottom; i <= top; i--) {
                result[i][left] = value;
                value++;
            }
            left++;
        }
        return result;
    }







    /**
     * Write an efficient algorithm that returns whether a value exists in an m x n matrix. This
     * matrix has properties:
     *     1) Integers in each row are sorted from left to right.
     *     2) The first integer of each row is greater than the last integer of the previous row.
     */
    public static boolean efficientMatrixSearch(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = (m * n) - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int middleX = middle / n;
            int middleY =  middle % n;

            if (matrix[middleX][middleY] == target)
                return true;
            else if (matrix[middleX][middleY] < target)
                start = middle + 1;
            else if (matrix[middleX][middleY] > target)
                end = middle - 1;

        }
        return false;
    }






    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has
     * the following properties:
     *     1) Integers in each row are sorted in ascending from left to right.
     *     2) Integers in each column are sorted in ascending from top to bottom.
     */
    public static boolean efficientMatrixSearch2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length - 1;

        int i = m;
        int j = 0;

        while (i >= 0 && j <= n) {
            if (target < matrix[i][j])
                i--;
            else if (target > matrix[i][j])
                j++;
            else
                return true;
        }

        return false;
    }
}
