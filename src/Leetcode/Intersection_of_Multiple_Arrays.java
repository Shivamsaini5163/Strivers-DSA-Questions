package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 2248
//Time and Space Complexity =>  O(N) O(K)
public class Intersection_of_Multiple_Arrays {
    public List<Integer> intersection(int[][] nums) {
        int[] arr=new int[1001];
        List<Integer> list=new ArrayList<>();
        for(int[] num:nums){
            for(int n:num){
                arr[n]++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==nums.length){
                list.add(i);
            }
        }
        return list;
    }
}
