package arrays.arraymath;

/**
 * Created by hitesh-lalwani on 19/10/17.
 *
 You are given a read only array of n integers from 1 to n.

 Each integer appears exactly once except A which appears twice and B which is missing.

 Return A and B.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Note that in your output A should precede B.

 Example:

 Input:[3 1 2 5 3]

 Output:[3, 4]

 A = 3, B = 4
 */

public class RepeatAndMissingNumberArray {

    public static void main(String[] args) {
        RepeatAndMissingNumberArray sol = new RepeatAndMissingNumberArray();
        int[] A = {3, 1, 2, 3, 4};
        sol.print(sol.repeatedNumber(A));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private int[] repeatedNumber(final int[] A) {
        long n = A.length;
        long diff = 0;
        long diffSquare = 0;
        for (int i = 1; i <= n; ++i) {
            diff += ((long)i) - A[i - 1];
//            diffSquare += (i * i) - (A[i - 1] * A[i - 1]);
            diffSquare += (((long)i) + A[i - 1]) * (((long)i) - A[i - 1]);
        }

        long add = diffSquare / diff;

        long missing = (add + diff) / 2;
        long repeated = (add - diff) / 2;

        return new int[]{(int) repeated, (int) missing};
    }

    private void print(final int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
