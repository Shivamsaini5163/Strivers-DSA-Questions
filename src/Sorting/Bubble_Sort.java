package Sorting;

import java.util.Arrays;
//Space Complexity  =>  O(1)
//it means it is inplace sorting algorithm
//Best and Worst case time complexity   =>  O(N)    O(N^2)
//it is Stable Sorting Algorithm
public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr={3,1,5,4,2};
        System.out.println(Arrays.toString(bubble_sort(arr)));
    }
    private static int[] bubble_sort(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length-1; i++) {
            swapped=false;
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            //If you not swapped for a particular value of i this means it is sorted
            if (!swapped){
                break;
            }
        }
        return arr;
    }
}
