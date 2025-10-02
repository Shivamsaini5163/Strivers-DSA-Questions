package GFG;

import java.util.ArrayList;

// Same as leetcode 79 Word Search but use recursion because words may not be in straight line
// words are in straight line in this question so we use for loop
public class Find_the_string_in_grid {
    // 8 directions (dx, dy)
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int[][] searchWord(char[][] grid, String word) {
        int n = grid.length, m = grid[0].length;
        ArrayList<int[]> result = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == word.charAt(0)) {
                    if (existsFrom(grid, row, col, word, n, m)) {
                        result.add(new int[]{row, col});
                    }
                }
            }
        }
        // convert list → int[][]
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    private boolean existsFrom(char[][] grid, int row, int col, String word, int n, int m) {
        for (int dir = 0; dir < 8; dir++) {
            int x = row, y = col;
            int k;
            for (k = 0; k < word.length(); k++) {
                if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != word.charAt(k)) {
                    break;
                }
                x += dx[dir];
                y += dy[dir];
            }
            if (k == word.length()) return true;
        }
        return false;
    }
}
