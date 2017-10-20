package arrays.arraymath;

/**
 * Created by hitesh-lalwani on 20/10/17.
 *
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN.
 * In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N
 * and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

 Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 If you don’t want to perform the operation, return an empty array.
 Else, return an array consisting of two elements denoting L and R.
 If there are multiple solutions, return the lexicographically smallest pair of L and R.

 Notes:

 Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 For example,

 S = 010

 Pair of [L, R] | Final string
 _______________|_____________
 [1 1]          | 110
 [1 2]          | 100
 [1 3]          | 101
 [2 2]          | 000
 [2 3]          | 001

 We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 */
public class Flip {

    public static void main(String[] args) {
        Flip sol = new Flip();
        sol.print(sol.flip("0111"));
    }

    private int[] flip(String A) {
        if (isAllOnes(A)) {
            return new int[0];
        }
        int len = A.length();
        int start = 0, end = 0, maxSoFar = 0, maxEndingHere = Integer.MIN_VALUE, s = 0;
        for (int i = 0; i < len; ++i) {
            if(maxSoFar < 0) {
                maxSoFar = 0;
                s = i;
            }
            maxSoFar += A.charAt(i) == '0' ? 1 : -1;
            if (maxSoFar > maxEndingHere) {
                maxEndingHere = maxSoFar;
                start = s;
                end = i;
            }
        }
        return new int[]{start + 1, end + 1};
    }

    private boolean isAllOnes(String A) {
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    private void print(final int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
