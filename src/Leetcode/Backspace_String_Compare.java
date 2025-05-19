package Leetcode;

import java.util.Stack;
//leetcode 844
public class Backspace_String_Compare {
    public static void main(String[] args) {
        String s="y#fo##f";
        String t="y#f#o##f";
        System.out.println(backspaceCompare(s,t));
    }
    //Method 1
    //   Time and Space Complexity =>  O(N) O(1)
    public static boolean backspaceCompare(String s, String t) {
        int hashCountS=0,hashCountT=0;
        int i=s.length()-1;
        int j=t.length()-1;
        while(i>=0||j>=0){
            //skip # and those characters which are backspaced
            while (i>=0&&(s.charAt(i)=='#'||hashCountS>0)){
                if (s.charAt(i)=='#'){
                    hashCountS++;
                }else {
                    hashCountS--;
                }
                i--;
            }
            while (j>=0&&(t.charAt(j)=='#'||hashCountT>0)){
                if (t.charAt(j)=='#'){
                    hashCountT++;
                }else {
                    hashCountT--;
                }
                j--;
            }
            //if anyone goes out of bound then
            if ((i>=0&&j<0)||(j>=0&&i<0)){  //if one finishes and other is remaining
                return false;
            }
            if (i>=0&&j>=0&&(s.charAt(i)!=t.charAt(j))){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
//    Method 2
//   Time and Space Complexity =>  O(N) O(N)
    public static boolean backspaceCompare2(String s, String t) {
        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for (char ch:s.toCharArray()) {
            if (ch=='#'&&stack1.size()!=0){
                stack1.pop();
            }
            else if (ch!='#') { //we don't use else here because if we do then if  string is a## then second get push into stack
                stack1.push(ch);
            }
        }
        for (char ch:t.toCharArray()) {
            if (ch=='#'&&stack2.size()!=0){
                stack2.pop();
            }
            else if (ch!='#'){
                stack2.push(ch);
            }
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
