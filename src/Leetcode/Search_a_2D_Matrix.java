package Leetcode;
//leetcode 74
public class Search_a_2D_Matrix {
    //Method 1
    public boolean searchMatrix(int[][] mat, int target) {
        int r=0;
        int c=mat[0].length-1;
        while (r< mat.length){
            if (target==mat[r][c]){
                return true;
            } else if (target>mat[r][c]) {
                r++;
            }else {
                return binarySearch(mat,r,target);
            }
        }
        return false;
    }
    private boolean binarySearch(int[][] mat,int r,int target){
        int l=0;
        int h= mat[0].length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if (target==mat[r][mid]){
                return true;
            }
            else if (target>mat[r][mid]){
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return false;
    }
    //Method 2 Better Approach
    public boolean searchMatrix2(int[][] mat, int target) {
        int rows = mat.length;
        int cols = mat[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Map the 1D index `mid` to 2D matrix coordinates
            int midValue = mat[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false; // Target not found
    }
}
