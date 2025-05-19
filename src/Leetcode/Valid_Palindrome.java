package Leetcode;
//leetcode 125
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for (char ch:s.toCharArray()) {
            if (Character.isAlphabetic(ch)||Character.isDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        int r=sb.length()-1;
        int l=0;
        while(l<r){
            if (sb.charAt(l)!=sb.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
