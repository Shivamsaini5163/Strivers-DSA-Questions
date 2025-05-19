package Leetcode;

import java.util.Stack;
//leetcode 1047
//Time and Space Complexity =>    O(N) O(N)
public class Remove_All_Adjacent_Duplicates_In_String {
    public static void main(String[] args) {
        String s="azxxzy";
        System.out.println(removeDuplicates(s));
    }
    public static String removeDuplicates(String s) {
        StringBuilder stack=new StringBuilder();
        for (char ch:s.toCharArray()) {
            if (stack.length()!=0&&stack.charAt(stack.length()-1)==ch){
                stack.deleteCharAt(stack.length()-1);
            }else {
                stack.append(ch);
            }
        }
        return stack.toString();
    }
}
