package arrays.arraymath;

/**
 * Created by hitesh-lalwani on 17/10/17.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example:

 Given the array [-2,1,-3,4,-1,2,1,-5,4],

 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 For this problem, return the maximum sum.
 */

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {
        MaxSumContiguousSubarray sol = new MaxSumContiguousSubarray();
        int[] A = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(sol.maxSubArray(A));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private int maxSubArray(final int[] A) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int num : A) {
            maxEndingHere += num;
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
