package Leetcode;
//leetcode 48
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //transpose the matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(matrix,i,j,j,i);
            }
        }
        //reverse each row of matrix
        for(int i=0;i<n;i++){
            int l=0;
            int h=n-1;
            while(l<h){
                swap(matrix,i,l,i,h);
                l++;
                h--;
            }
        }
    }
    void swap(int[][] matrix,int a,int b,int c,int d){
        int temp=matrix[a][b];
        matrix[a][b]=matrix[c][d];
        matrix[c][d]=temp;
    }

    // If Matrix is not Squared
    int[][] rotateMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rotated = new int[n][m]; // new matrix of n rows, m columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }
}
