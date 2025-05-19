package Sorting;

import java.util.Arrays;

public class Recursive_Insertion_Sort {
    public static void main(String[] args) {
        int[] arr={5,3,7,15,0};
        System.out.println(Arrays.toString(insertion_sort(arr)));
    }
    private static int[] insertion_sort(int[] arr){
        return helper(arr,1);
    }
    private static int[] helper(int[] arr,int end){
        if (end==arr.length){
            return arr;
        }
        int key=arr[end];
        int j=end-1;
        while (j>=0 && key<arr[j]){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
        return helper(arr,end+1);
    }
}
