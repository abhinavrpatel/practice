
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
}
