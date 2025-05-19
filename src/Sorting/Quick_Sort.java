package Sorting;

import java.util.Arrays;
//Not Stable
//Inplace Sorting
//Best and Worst Case   =>  O(NlogN) O(N^2)
public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        System.out.println(Arrays.toString(quick_sort(arr,0, arr.length-1)));
    }
    private static int[] quick_sort(int[] arr,int l,int h){
        if (l<h){
            int p=pivot(arr,l,h);
            quick_sort(arr,l,p-1);
            quick_sort(arr,p+1,h);
        }
        return arr;
    }
    private static int pivot(int[] arr,int l,int h){
        int p=arr[h];
        int i=l-1;
        for (int j = l; j <= h-1; j++) {
            if(p>arr[j]){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
