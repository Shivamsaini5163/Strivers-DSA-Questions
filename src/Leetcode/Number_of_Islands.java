package Leetcode;

//leetcode 200
public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // Check boundaries
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;

        // Mark current cell as visited
        grid[i][j] = '0';

        // Visit all 4 directions (up, down, left, right)
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }
}
