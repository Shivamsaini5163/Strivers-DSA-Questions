package Leetcode;

//leetcode 1351
public class Count_Negative_Numbers_in_a_Sorted_Matrix {
//    O(M+N)
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //start form bottom left
        int r=m-1;
        int c=0;
        int cnt=0;
        while(r>=0&&c<n){
            if(grid[r][c]<0){
                cnt+=n-c;
                r--;
            }
            else c++;
        }
        return cnt;
    }
    //OR
    public int countNegatives2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int row = 0, col = n - 1; // start from top-right

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                // All elements below in this column are also negative
                count += (m - row);
                col--; // move left
            } else {
                row++; // move down
            }
        }
        return count;
    }
}
