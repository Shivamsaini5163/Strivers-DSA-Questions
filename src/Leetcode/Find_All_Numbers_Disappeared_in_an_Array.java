package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 448
public class Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        int i=0;
        ArrayList<Integer> list=new ArrayList<>();
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
                list.add(i+1);
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