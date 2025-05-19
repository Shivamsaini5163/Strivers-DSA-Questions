package Leetcode;
//leetcode 287
public class Find_the_Duplicate_Number{
    public int findDuplicate(int[] arr) {
        int i=0;
        while (i<arr.length){
            int correctIdx=arr[i]-1;
            if (arr[i]!=arr[correctIdx]){
                swap(arr,i,correctIdx);
            }else {
                i++;
            }
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]-1!=i){
                return arr[i];
            }
        }
        return -1;
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
