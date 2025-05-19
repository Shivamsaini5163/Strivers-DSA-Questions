package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 442
public class Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] arr) {
        //using cyclic sort
        int i=0;
        List<Integer> list=new ArrayList<>();
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
                list.add(arr[i]);
            }
        }
        return list;
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
