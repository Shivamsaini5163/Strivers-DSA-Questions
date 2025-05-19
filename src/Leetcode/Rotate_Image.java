package Leetcode;
//leetcode 48
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        //transpose the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse each row of matrix
        for(int i=0;i<matrix.length;i++){
            int l=0;
            int r=matrix[0].length-1;
            while(l<r){
                int temp=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=temp;
                l++;
                r--;
            }
        }
    }
}
