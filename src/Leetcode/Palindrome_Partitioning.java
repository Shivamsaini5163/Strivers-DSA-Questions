package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 131
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        helper(s,list,new ArrayList<>(),0);
        return list;
    }
    void helper(String s,List<List<String>> list,List<String> ans,int i){
        if(i==s.length()){
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s.substring(i,j+1))){
                ans.add(s.substring(i,j+1));
                helper(s,list,ans,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }
    boolean isPalindrome(String str){
        int l=0;
        int h=str.length()-1;
        while(l<h){
            if(str.charAt(l)!=str.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}
