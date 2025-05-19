package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
//leetcode 219

public class Contains_Duplicate_II {
    public static void main(String[] args) {
        int[] nums={1,2,3,1,2,3};
        int k=2;
        System.out.println(containsNearbyDuplicate2(nums,k));
    }
    //Time and Space Complexity =>  O(N) O(N)
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])&&i-map.get(nums[i])<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    //Time and Space Complexity =>  O(N) O(K)
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
