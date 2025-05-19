package Leetcode;
//leetcode 498
public class Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] arr=new int[m*n];
        int r=0;
        int c=0;
        for(int i=0;i<arr.length;i++){
            arr[i]=mat[r][c];
            if((r+c)%2==0){// moving up
                if(c==n-1){r++;}
                else if(r==0){c++;}
                else{r--;c++;}
            }else{// moving down
                if(r==m-1)  {c++;}
                else if(c==0) {r++;}
                else{r++; c--;}
            }
        }
        return arr;
    }
}
