package Leetcode;
//leetcode 1544
//Time and Space Complexity =>    O(N) O(1)
public class Make_The_String_Great {
    //using Stack like string builder
    //here space complexity is O(1) not O(N) because we have to take string builder because we are returning string as
    // ans and strings are immutable so we need new string in any situation
    public String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(sb.length()!=0&&Math.abs(sb.charAt(sb.length()-1)-ch)==32){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
