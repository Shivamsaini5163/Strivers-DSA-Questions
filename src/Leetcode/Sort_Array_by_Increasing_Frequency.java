package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

//leetcode 1636
public class Sort_Array_by_Increasing_Frequency {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // Step 2: Convert array to Integer[] for custom sorting
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i]; // auto-boxing from int → Integer
        }
        // Step 3: Sort using custom comparator
        Arrays.sort(arr, (a, b) -> {
            int x = map.get(a); // frequency of element a
            int y = map.get(b); // frequency of element b
            if (x != y) {
                return x - y; // smaller frequency first
            } else {
                return b - a; // if frequency same, larger number first
            }
        });
        // Step 4: Convert back to int[]
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i]; // auto-unboxing from Integer → int
        }
        return result;
    }
}
