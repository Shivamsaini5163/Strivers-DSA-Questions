package Sorting;

import java.util.Arrays;

public class Cyclic_Sort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr){
        int i=0;
        while (i<arr.length){
            if (arr[i]-1==i){
                i++;
            }else {
                int correctIdx=arr[i]-1;
                swap(arr,i,correctIdx);
            }
        }
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
