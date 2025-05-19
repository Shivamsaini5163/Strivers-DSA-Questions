package Leetcode;

import java.util.List;
//leetcode 2824
//Time and Space Complexity =>  O(NlogN) O(1)
public class Count_Pairs_Whose_Sum_is_Less_than_Target {
    public int countPairs(List<Integer> nums, int target) {
        int res=0;
        nums.sort((a,b)->a-b);
        int l=0;
        int r=nums.size()-1;
        while (l<r){
            if (nums.get(l)+nums.get(r)>=target){
                r--;
            }
            else {
                res+=r-l;
                l++;
            }
        }
        return res;
    }
}
