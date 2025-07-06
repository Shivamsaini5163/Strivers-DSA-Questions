package Leetcode;

import java.util.*;
//leetcode 40
public class Combination_Sum_II {
    //Brute force using HashSet
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);    // sort to help Set remove duplicates
        helper(candidates, target, set, ans, 0);
        return new ArrayList<>(set);
    }

    void helper(int[] candidates, int target, Set<List<Integer>> set, List<Integer> ans, int i) {
        if (i == candidates.length) {
            if (target == 0) {
                List<Integer> copy = new ArrayList<>(ans);
                set.add(copy);
            }
            return;
        }
        if (candidates[i] <= target) {
            //include current value and move to the next value
            ans.add(candidates[i]);
            helper(candidates, target - candidates[i], set, ans, i + 1);
            //exclude current value and move to the next value
            ans.remove(ans.size() - 1);
        }
        helper(candidates, target, set, ans, i + 1);
    }
    //Optimized Approach
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, list, ans, 0);
        return list;
    }

    void helper(int[] candidates, int target, List<List<Integer>> list, List<Integer> ans, int i) {
        if (target == 0) {
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<candidates.length;j++){
            if (j>i&&candidates[j]==candidates[j-1]) continue;  //skipping duplicates
            if (candidates[j]>target) break;
            ans.add(candidates[j]);
            helper(candidates,target-candidates[j],list,ans,j+1);
            ans.remove(ans.size() - 1);
        }
    }
}
