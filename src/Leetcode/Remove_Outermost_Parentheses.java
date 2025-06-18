package Leetcode;

import java.util.Stack;
//leetcode 1021
public class Remove_Outermost_Parentheses {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }
    //Brute Force   Time=> O(N^2)   Space=> O(N)
    public static String removeOuterParentheses(String s) {
        int count=0;
        Stack<Character> st=new Stack<>();
        String ans="";
        String str="";
        for (char i:s.toCharArray()) {
            if (i=='('){
                st.push(i);
                count++;
            }else {
                st.push(i);
                count--;
                if (count==0){
                    st.pop();
                    while(st.size()!=1){
                        str=st.pop()+str;
                    }
                    st.pop();
                    ans=ans+str;
                    str="";
                }
            }
        }
        return ans;
    }
    //Better Approach   Time=> O(N^2)   Space=> O(N)
        //why this complexity happened? because string are immutable and when we concatenate in it then it creates new string so it is recommended to use string builder
    public String removeOuterParentheses2(String s) {
        int depth=0;
        String str="";
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(depth>0) str=str+ch;
                depth++;
            }else{
                depth--;
                if(depth>0) str=str+ch;
            }
        }
        return str;
    }
    //Optimized Approach   Time=> O(N)   Space=> O(N)
    public static String removeOuterParentheses3(String s) {
        StringBuilder out = new StringBuilder();
        int depth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) out.append(ch); // only append if not outermost
                depth++;
            } else {
                depth--;
                if (depth > 0) out.append(ch); // only append if not outermost
            }
        }
        return out.toString();
    }
}
