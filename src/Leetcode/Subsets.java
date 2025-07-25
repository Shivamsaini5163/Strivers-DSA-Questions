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
    // Using Bit Manipulation (Better Approach)
    // Time=>  O(2^n * n)        Space=> O(2^n * n)
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        int subsets=1<<n;   // no. of subsets possible is 2^n
        for(int i=0;i<subsets;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                //check jth bit is set or not and if it is then add it to your list
                if((i&(1<<j))!=0){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
