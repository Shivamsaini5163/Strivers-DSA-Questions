package Leetcode;

import java.util.Arrays;
//leetcode 2965
public class Find_Missing_and_Repeated_Values {
    public static void main(String[] args) {
        int[][] grid={{9, 1, 7},
                {8, 9, 2},
                {3, 4, 6}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues2(grid)));
    }
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        //this one is using space so we go with optimized approach
        int n = grid.length;
        int nSquared = n * n;
        int[] count = new int[nSquared + 1]; // Frequency array
        int[] result = new int[2]; // To store the repeated and missing numbers

        // Populate the frequency array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                count[num]++;
            }
        }

        // Identify the repeated and missing numbers
        for (int i = 1; i <= nSquared; i++) {
            if (count[i] == 2) {
                result[0] = i; // Repeated number
            } else if (count[i] == 0) {
                result[1] = i; // Missing number
            }
        }
        return result;
    }
    public static int[] findMissingAndRepeatedValues2(int[][] grid) {
        //this is optimized approach using constant space
        int n = grid.length;
        long nSquared = n * n;
        long expectedSum = nSquared * (nSquared + 1) / 2;
        long expectedSumSq = nSquared * (nSquared + 1) * (2 * nSquared + 1) / 6;
        long actualSum = 0;
        long actualSumSq = 0;

        // Traverse the grid to calculate actual sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;
                actualSumSq += num * num;
            }
        }

        // Calculate differences
        long diff = expectedSum - actualSum;    //a-b
        long sqDiff = expectedSumSq - actualSumSq;  //a^2-b^2   to find a^2 and b^2 use (n*(n+1)*(2n+1))/6 formula

        // Solve for the missing and repeated numbers
        long sum = sqDiff / diff;   //a+b
        int missing = (int)((diff + sum) / 2); //a
        int  repeated= (int)(sum - missing);    //b

        return new int[]{repeated,missing};
    }
}
