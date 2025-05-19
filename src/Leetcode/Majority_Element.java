package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
//leetcode 169
public class Majority_Element {
    public static void main(String[] args) {
        int[] nums={1,3,3,3,3,5,7,3};
        System.out.println(majorityElement(nums));
    }
    //   Time and Space Complexity =>  O(N) O(1)
    //  Using Boyer-Moore Majority Voting Algo
    public static int majorityElement(int[] nums) {
        int count=0;
        int candidate=nums[0];
        for(int num:nums){
            if(count==0){   //it means someone beat our candidate so me assigned him as new candidate
                candidate=num;
            }
            count=(num==candidate)?count+1:count-1; //voting to our candidate if he wins then ++ otherwise --
        }
        return candidate;
    }
    //Using hash map but space goes O(N)
    public int majorityElement2(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>nums.length/2){
                return key;
            }
        }
        return -1;
    }
    //it not use hash map so O(1) space but time complexity is O(NlogN)
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
