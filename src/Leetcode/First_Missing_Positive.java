package Leetcode;
//leetcode 41
//HARD
//using cyclic sort but no hint is given in question like range
public class First_Missing_Positive {
    public int firstMissingPositive(int[] arr) {
        int i=0;
        while (i<arr.length){
            int correctIdx=arr[i]-1;
            if (arr[i]>0&&arr[i]<=arr.length&&arr[i]!=arr[correctIdx]){
                swap(arr,i,correctIdx);
            }else {
                i++;
            }
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]-1!=i){
                return i+1;
            }
        }
        return i+1;
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
