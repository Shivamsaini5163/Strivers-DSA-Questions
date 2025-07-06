package Leetcode;
import java.util.*;
//leetcode 90
public class Subsets_II {
    //Brute Force using HashSet
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        generate(nums,0,set,ans);
        return new ArrayList<>(set);
    }
    void generate(int[] nums,int i,Set<List<Integer>> set,List<Integer> ans){
        if(nums.length==i){
            set.add(new ArrayList<>(ans));
            return;
        }
        // Include current element
        ans.add(nums[i]);
        generate(nums,i+1,set,ans);
        // Exclude current element (backtrack)
        ans.remove(ans.size() - 1);
        generate(nums,i+1,set,ans);
    }
    //Optimized Approach
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        generate(nums,0,list,ans);
        return list;
    }
    void generate(int[] nums,int i,List<List<Integer>> list,List<Integer> ans){
        list.add(new ArrayList<>(ans));
        for(int j=i;j<nums.length;j++){
            if (j>i&&nums[j]==nums[j-1]) continue;  //skipping duplicates
            ans.add(nums[j]);
            generate(nums,j+1,list,ans);
            ans.remove(ans.size() - 1);
        }
    }
}
