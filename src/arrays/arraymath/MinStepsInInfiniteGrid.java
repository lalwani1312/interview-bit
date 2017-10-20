package arrays.arraymath;

/**
 * Created by hitesh-lalwani on 15/10/17.
 *
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to
 (x+1, y),
 (x - 1, y),
 (x, y+1),
 (x, y-1),
 (x-1, y-1),
 (x+1,y+1),
 (x-1,y+1),
 (x+1,y-1)
 You are given a sequence of points and the order in which you need to cover the points.
 Give the minimum number of steps in which you can achieve it. You start from the first point.

 Example :

 Input : [(0, 0), (1, 1), (1, 2)]
 Output : 2
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

 This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 */

public class MinStepsInInfiniteGrid {

    public static void main(String[] args) {
        MinStepsInInfiniteGrid sol = new MinStepsInInfiniteGrid();
        int X[] = {5, 7, 4, 8};
        int Y[] = {8, 4, 2, 7};
        System.out.println(sol.coverPoints(X, Y));
    }

    private int abs(int a) {
        return a < 0 ? -a : a;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int coverPoints(int[] X, int[] Y) {
        int len = X.length;
        int minSteps = 0;
        for (int i = 1; i < len; ++i) {
            minSteps += max(abs(X[i] - X[i - 1]), abs(Y[i] - Y[i - 1]));
        }
        return minSteps;
    }
}
