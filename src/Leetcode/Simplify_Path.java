package Leetcode;

import java.util.Stack;
//leetcode 71
//Time and Space Complexity =>    O(N) O(N)
public class Simplify_Path {
    public String simplifyPath(String path) {
        String[] str=path.split("/");   //split it in strings present between /"string"/    if // then it has empty string
        Stack<String> st=new Stack<>();
        for(String s:str){
            if(s.equals("..")&&st.size()!=0){   //go back
                st.pop();
            }
            else if(!s.equals("..")&&!s.equals(".")&&!s.equals("")){    //ignore is . and empty there and it must not have .. otherwise consider all names
                st.push(s);
            }
        }
        StringBuilder sb=new StringBuilder();
        if(st.size()==0){
            return "/";
        }
        for(String i:st){
            sb.append("/");
            sb.append(i);
        }
        return sb.toString();
    }
}
