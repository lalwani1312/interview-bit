package arrays.arraymath;

/**
 * Created by hitesh-lalwani on 18/10/17.
 *
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

 For example,

 A=[1, 3, -1]

 f(1, 1) = f(2, 2) = f(3, 3) = 0
 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

 So, we return 5.
 */

public class MaximumAbsoluteDifference {

    public static void main(String[] args) {
        MaximumAbsoluteDifference sol = new MaximumAbsoluteDifference();
        int[] A = {1, 3, -1};
        System.out.println(sol.maxArr(A));
    }

    private int maxArr(int[] A) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            max1 = max(max1, A[i] + i);
            max2 = max(max2, -(A[i] - i));
            max3 = max(max3, A[i] - i);
            max4 = max(max4, -(A[i] + i));
        }
        int ans = 0;
        for (int j = 0; j < A.length; ++j) {
            ans = max(ans, max1 - (A[j] + j));
            ans = max(ans, max2 + (A[j] - j));
            ans = max(ans, max3 - (A[j] - j));
            ans = max(ans, max4 + (A[j] + j));
        }
        return ans;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

//    public int maxArr(int[] A) {
//        int max = 0;
//        for (int i = 1; i < A.length; ++i) {
//            for (int j = 0; j < i; ++j) {
//                int x = evaluate(A, i, j);
//                if (x > max) {
//                    max = x;
//                }
//            }
//        }
//        return max;
//    }
//
//    private int evaluate(int[] A, int i, int j) {
//        return abs(A[i] - A[j]) + abs(i - j);
//    }
//
//    private int abs(int a) {
//        return a < 0 ? -a : a;
//    }
}
