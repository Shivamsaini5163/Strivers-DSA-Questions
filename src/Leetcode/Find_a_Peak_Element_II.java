package Leetcode;

import java.util.Arrays;
//leetcode 1901
public class Find_a_Peak_Element_II {
    public static void main(String[] args) {
        int[][] mat={{2, 2, 5, 1, 4, 5}, {2, 9, 3, 2, 3, 2}, {1, 7, 6, 0, 1, 3}, {3, 6, 2, 3, 7, 2}};
        System.out.println(Arrays.toString(findPeakGrid2(mat)));
    }
    //Brute Force O(N^2)
    public static int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int max=Integer.MIN_VALUE;
        int x=-1;
        int y=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(max<mat[i][j]){
                    max=mat[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        return new int[]{x,y};
    }
    //Optimal Solution
    public static int[] findPeakGrid2(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int l=0;
        int h=col-1;
        while (l<=h){
            int midCol=l+(h-l)/2;
            int x=maxRowIndex(mat,row,midCol);
            int left=midCol-1>=0?mat[x][midCol-1]:-1;
            int right=midCol+1<col?mat[x][midCol+1]:-1;
            if (mat[x][midCol]>left&&mat[x][midCol]>right){
                return new int[]{x,midCol};
            }
            else if (mat[x][midCol]<left){
                h=midCol-1;
            }else {
                l=midCol+1;
            }
        }
        return new int[]{-1,-1};
    }
    private static int maxRowIndex(int[][] mat,int row,int n){
        int max=Integer.MIN_VALUE;
        int idx=-1;
        for (int i = 0; i < row; i++) {
            if (max<mat[i][n]){
                max=mat[i][n];
                idx=i;
            }
        }
        return idx;
    }
}
