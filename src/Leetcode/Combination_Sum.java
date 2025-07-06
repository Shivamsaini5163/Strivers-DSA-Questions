package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 39
//  O(2^target/min(candidate))    O(target)
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> ans =new ArrayList<>();
        helper(candidates,target,list,ans,0);
        return list;
    }
    void helper(int[] candidates, int target,List<List<Integer>> list,List<Integer> ans,int i){
        if(i== candidates.length){
            if(target==0){
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        if (candidates[i]<=target) {
            //include current value and remains here
            ans.add(candidates[i]);
            helper(candidates, target - candidates[i], list, ans, i);
            //exclude current value and move to the next value
            ans.remove(ans.size()-1);
        }
        helper(candidates,target,list,ans,i+1);
    }
}
