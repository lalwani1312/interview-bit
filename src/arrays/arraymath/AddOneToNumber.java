package arrays.arraymath;

/**
 * Created by hitesh-lalwani on 17/10/17.
 * <p>
 * Given a non-negative number represented as an array of digits,
 * <p>
 * add 1 to the number ( increment the number represented by the digits ).
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * If the vector has [1, 2, 3]
 * <p>
 * the returned vector should be [1, 2, 4]
 * <p>
 * as 123 + 1 = 124.
 * <p>
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 * For example, for this problem, following are some good questions to ask :
 * Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {

    public static void main(String[] args) {
        AddOneToNumber sol = new AddOneToNumber();
        int[] number = {0, 0, 0, 9, 9, 8};
        sol.print(sol.plusOne(number));
    }

    private int[] plusOne(int[] A) {
        int carry = 1, temp;
        for (int i = A.length - 1; i >= 0; --i) {
            temp = A[i] + carry;
            A[i] = temp % 10;
            carry = temp / 10;
        }
        int[] result;
        int index;
        if (carry > 0) {
            result = new int[A.length + 1];
            //carry = 1 will be the first digit.
            result[0] = carry;
            index = 1;

            //copy remaining digits to the result array.
            for (int digit : A) {
                result[index] = digit;
                ++index;
            }
        } else {
            int i = 0;
            //skip all leading zeroes.
            while (A[i] == 0) {
                ++i;
            }
            //copy remaining digits to the result array.
            result = new int[A.length - i];
            index = 0;
            while (i < A.length) {
                result[index] = A[i];
                ++i;
                ++index;
            }
        }

        return result;
    }

    private void print(int[] A) {
        for (int digit : A) {
            System.out.print(digit + " ");
        }
    }
}
