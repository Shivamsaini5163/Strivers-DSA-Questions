package Leetcode;
//leetcode 73
//Time and Space Complexity =>    O(M*N) O(M+N)
public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        boolean[] zeroRows=new boolean[matrix.length];
        boolean[] zeroCols=new boolean[matrix[0].length];
        int i,j;
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    zeroRows[i]=true;
                    zeroCols[j]=true;
                }
            }
        }
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                if(zeroRows[i]){
                    matrix[i][j]=0;
                }
            }
        }
        for(j=0;j<matrix[0].length;j++){
            for(i=0;i<matrix.length;i++){
                if(zeroCols[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
