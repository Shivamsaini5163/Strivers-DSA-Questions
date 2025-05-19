package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
//leetcode 1
//Time and Space Complexity =>    O(N) O(N)
public class Two_Sum {
    public static void main(String[] args) {
        int[] arr={3,2,4};
        int target=6;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }
    public static int[] twoSum(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(k-arr[i])){
                return new int[]{map.get(k-arr[i]),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
}
