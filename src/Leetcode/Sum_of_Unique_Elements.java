package Leetcode;

import java.util.HashMap;
//leetcode 1748
//Time and Space Complexity =>    O(N) O(N)
public class Sum_of_Unique_Elements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(sumOfUnique(nums));
    }
    public static int sumOfUnique(int[] nums) {
        int ans=0;
        int[] arr=new int[101];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < 101; i++) {
            if (arr[i]==1){
                ans+=i;
            }
        }
        return ans;
    }
}
