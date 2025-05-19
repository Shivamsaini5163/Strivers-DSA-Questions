package Leetcode;
//leetcode 283
public class Move_Zeroes {
    public void moveZeroes(int[] arr) {
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=0){
                arr[i]=arr[j];
                if(i!=j){
                    arr[j]=0;
                }
                i++;
            }
        }
    }
}
