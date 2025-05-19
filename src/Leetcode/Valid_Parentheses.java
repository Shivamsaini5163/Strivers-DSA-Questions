package Leetcode;

import java.util.Stack;
//leetcode 20
//Time and Space Complexity =>  O(N) O(N)
public class Valid_Parentheses {
    public static void main(String[] args) {
        String s="(]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        char[] ch=s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (ch[i]=='{'||ch[i]=='['||ch[i]=='('){
                st.push(ch[i]);
            } else if (ch[i]=='}') {
                boolean val=check(st,'{');
                if (!val){
                    return false;
                }
            } else if (ch[i]==')') {
                boolean val=check(st,'(');
                if (!val){
                    return false;
                }
            } else if (ch[i]==']') {
                boolean val=check(st,'[');
                if (!val){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    private static boolean check(Stack<Character> st,char ch){
        if (st.isEmpty()){
            return false;
        }
        return st.pop() == ch;
    }
}
