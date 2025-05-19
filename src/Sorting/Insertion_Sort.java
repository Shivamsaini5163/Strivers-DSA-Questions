package Sorting;

import java.util.Arrays;

//Best and Worst case time complexity   =>  O(N)    O(N^2)
//it is Stable Sorting Algorithm
public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr={5,3,4,1,2};
        System.out.println(Arrays.toString(insertion_sort(arr)));
    }
    private static int[] insertion_sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        return arr;
    }
}
