package arrays;

/**
 * Created by hitesh-lalwani on 15/10/17.
 *
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Example:

 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return

 [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */

public class SpiralOrderMatrix1 {

    private static final int EAST = 0;
    private static final int SOUTH = 1;
    private static final int WEST = 2;
    private static final int NORTH = 3;

    public static void main(String[] args) {
        SpiralOrderMatrix1 sol = new SpiralOrderMatrix1();
        int[][] A = {
                {1, 2, 3, 10},
                {4, 5, 6, 20},
                {7, 8, 9, 30}
        };
        sol.printArray(sol.spiralOrder(A));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private int[] spiralOrder(final int[][] A) {
        int[] result = new int[A.length * A[0].length];
        int left = 0, top = 0, right = A[0].length - 1, bottom = A.length - 1;
        int index = 0, direction = EAST;
        while (top <= bottom && left <= right) {
            if (direction == EAST) {
                for (int i = left; i <= right; ++i) {
                    result[index++] = A[top][i];
                }
                ++top;
                direction = SOUTH;
            } else if (direction == SOUTH) {
                for (int i = top; i <= bottom; ++i) {
                    result[index++] = A[i][right];
                }
                --right;
                direction = WEST;
            } else if (direction == WEST) {
                for (int i = right; i >= left; --i) {
                    result[index++] = A[bottom][i];
                }
                --bottom;
                direction = NORTH;
            } else if (direction == NORTH) {
                for (int i = bottom; i >= top; --i) {
                    result[index++] = A[i][left];
                }
                ++left;
                direction = EAST;
            }
        }
        return result;
    }

    private void printArray(final int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
