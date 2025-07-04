package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 78
public class Subsets {
//    Time=>  O(2^n * n)        Space=> O(n) + O(2^n * n)
    //Using Recursion
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        generate(nums,0,list,ans);
        return list;
    }
    void generate(int[] nums,int i,List<List<Integer>> list,List<Integer> ans){
        if(nums.length==i){
            list.add(new ArrayList<>(ans));
            return;
        }
        // Include current element
        ans.add(nums[i]);
        generate(nums,i+1,list,ans);
        // Exclude current element (backtrack)
        ans.remove(ans.size() - 1);
        generate(nums,i+1,list,ans);
    }
}
