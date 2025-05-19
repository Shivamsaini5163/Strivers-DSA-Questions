package Array;

import java.util.Arrays;

public class Binary_search_in_2DArray {
    public static void main(String[] args) {
        int[][] arr={{10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};
        System.out.println(Arrays.toString(search(arr,37)));

        int[][] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.toString(search2(mat,5)));
    }
    //Matrix must be sorted in row wise and column wise manner
    private static int[] search(int[][] mat,int target){
        int r=0;
        int c=mat[0].length-1;
        while(r<mat.length&&c>=0){
            if (target==mat[r][c]){
                return new int[]{r,c};
            } else if (target>mat[r][c]) {
                r++;
            }else {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
    //Matrix must be sorted completely
    //Approach 1 but not good
    private static int[] search2(int[][] mat,int target){
        int r=0;
        int c=mat[0].length-1;
        while (r< mat.length){
            if (target==mat[r][c]){
                return new int[]{r,c};
            } else if (target>mat[r][c]) {
                r++;
            }else {
                return binarySearch(mat,r,target);
            }
        }
        return new int[]{-1,-1};
    }
    private static int[] binarySearch(int[][] mat,int r,int target){
        int l=0;
        int h= mat[0].length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if (target==mat[r][mid]){
                return new int[]{r,mid};
            }
            else if (target>mat[r][mid]){
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    //Approach 2 Very good
    private static int[] searchInSortedMatrix(int[][] mat, int target) {
        int rows = mat.length;
        int cols = mat[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Map the 1D index `mid` to 2D matrix coordinates
            int midValue = mat[mid / cols][mid % cols];

            if (midValue == target) {
                return new int[]{mid / cols, mid % cols};
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1}; // Target not found
    }
}
