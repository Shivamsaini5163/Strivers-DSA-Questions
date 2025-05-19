package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

///Time and Space complexity is O(N+K)
//Not inplace sorting algorithm
public class Count_Sort {
    public static void main(String[] args) {
        int[] arr={3,4,1,3,2,5,2,8};
        count_sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    //this is unstable version of count sort
    private static void count_sort(int[] arr){
        int max=max(arr);
        int idx=0;
        int[] count=new int[max+1];
        for (int j : arr) {
            count[j]++;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]!=0){
                arr[idx++]=i;
                count[i]--;
            }
        }
    }
    private static int max(int[] arr){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Integer.max(max,arr[i]);
        }
        return max;
    }
    //this is stable version of count sort
    private static void count_sort2(int[] arr){
        int max=Arrays.stream(arr).max().getAsInt();
        int[] count=new int[max+1];
        for (int j : arr) {
            count[j]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i]+=count[i-1];
        }
        int[] output=new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            output[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }
        //change the original array
        System.arraycopy(output,0,arr,0,arr.length);
    }
}
