package Leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode 17
public class Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        String[] map={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb=new StringBuilder();
        List<String> list=new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        helper(digits,list,sb,map,0);
        return list;
    }
    void helper(String digits,List<String> list,StringBuilder sb,String[] map,int i){
        if(i==digits.length()){
            list.add(sb.toString());
            return;
        }
        String letters=map[digits.charAt(i)-'0'];
        for(char ch:letters.toCharArray()){
            sb.append(ch);
            helper(digits,list,sb,map,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
