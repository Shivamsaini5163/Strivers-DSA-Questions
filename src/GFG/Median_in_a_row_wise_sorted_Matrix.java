package GFG;
import java.util.*;
public class Median_in_a_row_wise_sorted_Matrix{
    //Brute Force O(M*N) + O(M*N (log(M*N)))
    int median(int mat[][]) {
        List<Integer> list=new ArrayList<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(mat[i][j]);
            }
        }
        Collections.sort(list);
        return list.get((m*n)/2);
    }
    //Optimal Approach
    int median2(int mat[][]) {
        int high=Integer.MIN_VALUE;
        int low=Integer.MAX_VALUE;
        int m= mat.length;
        int n=mat[0].length;
        for (int i=0;i<mat.length;i++){
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][n-1]);
        }
        int req=(m*n)/2;
        while (low<=high){
            int mid=low+(high-low)/2;
            int count=smallEquals(mat,mid,m,n);
            if (count<=req) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    private static int smallEquals(int[][] mat,int num,int row,int col){
        int count=0;
        for (int i=0;i<row;i++){
            count+=upperBound(mat,num,i,col);
        }
        return count;
    }
    private static int upperBound(int[][] mat,int num,int row,int col){
        if (mat[row][0]>num){
            return 0;
        }
        int l=0;
        int h=col-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (mat[row][mid]<=num){
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        return l;
    }
}
