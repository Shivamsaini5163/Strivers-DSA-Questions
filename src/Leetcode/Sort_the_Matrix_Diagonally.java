package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode 1329
public class Sort_the_Matrix_Diagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Process diagonals starting from first row
        for (int col = 0; col < n; col++) {
            sortDiagonal(mat, 0, col, m, n);
        }

        // Process diagonals starting from first column (excluding [0,0] diagonal)
        for (int row = 1; row < m; row++) {
            sortDiagonal(mat, row, 0, m, n);
        }

        return mat;
    }
    private void sortDiagonal(int[][] mat, int row, int col, int m, int n) {
        List<Integer> list = new ArrayList<>();
        int r = row, c = col;

        // Step 1: Collect diagonal elements
        while (r < m && c < n) {
            list.add(mat[r][c]);
            r++;
            c++;
        }

        // Step 2: Sort the diagonal
        Collections.sort(list);

        // Step 3: Put elements back
        r = row;
        c = col;
        int index = 0;
        while (r < m && c < n) {
            mat[r][c] = list.get(index++);
            r++;
            c++;
        }
    }
}
