package GFG;

import java.util.Arrays;

public class Number_of_paths {
    // Using Recursion
    public int numberOfPaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo) Arrays.fill(row, -1);
        return countPaths(0, 0, m, n, memo);
    }
    private int countPaths(int i, int j, int m, int n, int[][] memo) {
        // If reached bottom-right
        if (i == m-1 && j == n-1) return 1;

        // Check boundaries
        if (i >= m || j >= n) return 0;

        // Return if already computed
        if (memo[i][j] != -1) return memo[i][j];

        // Move down + move right
        memo[i][j] = countPaths(i+1, j, m, n, memo) + countPaths(i, j+1, m, n, memo);
        return memo[i][j];
    }

    // Using Combinatorics (Math)
//    From top-left (0,0) to bottom-right (m-1,n-1):
//    Total moves = (m-1) downs + (n-1) rights = (m+n-2) moves.
//    We need to choose (m-1) moves to go down (or (n-1) moves to go right).
//    Number of paths = (m + n - 2)! / ((m - 1)! * (n - 1)!)
    public int numberOfPaths2(int m, int n) {
        long res = 1; // use long to avoid overflow
        int N = m + n - 2; // total moves
        int k = m - 1;     // number of down moves

        // Compute nCr iteratively to avoid factorial overflow
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }

        return (int) res;
    }
}
