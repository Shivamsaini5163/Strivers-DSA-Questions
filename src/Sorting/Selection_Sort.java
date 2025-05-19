package Sorting;

import java.util.Arrays;
//Best and Worst case time complexity   =>  O(N^2)    O(N^2)
//it is not Stable Sorting Algorithm
public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr={-8,9,0,-3};
        System.out.println(Arrays.toString(selection_sort(arr)));
    }
    private static int[] selection_sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min=i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,min,i);
        }
        return arr;
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
