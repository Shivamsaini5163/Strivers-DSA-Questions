package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 216
public class Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        helper(k,n,list,ans,1);
        return list;
    }
    void helper(int k,int n,List<List<Integer>> list,List<Integer> ans,int i){
        if (n < 0) return;
        if(ans.size()==k){
            if(n==0){
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        if(i>9) return;
        ans.add(i);
        helper(k,n-i,list,ans,i+1);
        ans.remove(ans.size()-1);
        helper(k,n,list,ans,i+1);
    }
}
