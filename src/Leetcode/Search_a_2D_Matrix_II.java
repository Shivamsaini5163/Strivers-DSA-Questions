package Leetcode;
//leetcode 240
public class Search_a_2D_Matrix_II{
    public boolean searchMatrix(int[][] mat, int target) {
        int r=0;
        int c=mat[0].length-1;
        while(r<mat.length&&c>=0){
            if (target==mat[r][c]){
                return true;
            } else if (target>mat[r][c]) {
                r++;
            }else {
                c--;
            }
        }
        return false;
    }
}
