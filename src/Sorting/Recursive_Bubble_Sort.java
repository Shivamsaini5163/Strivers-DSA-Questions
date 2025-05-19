package Sorting;

import java.util.Arrays;

public class Recursive_Bubble_Sort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        System.out.println(Arrays.toString(bubble_sort(arr)));
    }
    private static int[] bubble_sort(int[] arr){
        return helper(arr,arr.length-1);
    }
    private static int[] helper(int[] arr,int end){
        if (end==0){
            return arr;
        }
        for (int i = 0; i <end ; i++) {
            if (arr[i]>arr[i+1]){
                //just swap
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        return helper(arr,end-1);
    }
}
