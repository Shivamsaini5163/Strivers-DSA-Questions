package Sorting;

import java.util.Arrays;
import java.util.Vector;

//Best and Worst Case   =>  O(NlogN)   O(NlogN)
//not inplace sort
//stable sort
public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        System.out.println(Arrays.toString(merge_sort(arr,0, arr.length-1)));
    }
    private static int[] merge_sort(int[] arr,int l,int h){
        if (l<h){
            int mid=l+(h-l)/2;
            merge_sort(arr,l,mid);
            merge_sort(arr,mid+1,h);
            merge(arr,l,mid,h);
        }
        return arr;
    }
    private static void merge(int[] arr,int l,int mid,int h){
        int n1=mid-l+1;
        int n2=h-mid;
        int[] left=new int[n1];
        int[] right=new int[n2];
        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr,mid+1,right,0,n2);
        int i=0;
        int j=0;
        int k=l;
        while (i<n1&&j<n2){
            if (left[i]<right[j]){
                arr[k++]=left[i++];
            }
            else {
                arr[k++]=right[j++];
            }
        }
        while (i<n1){
            arr[k++]=left[i++];
        }
        while (j<n2){
            arr[k++]=right[j++];
        }
    }
}
