package Leetcode;
//leetcode 2390
//Time and Space Complexity => O(N) O(N)
public class Removing_Stars_From_a_String {
//    Method 1  using stack
    public String removeStars(String s) {
        StringBuilder stack=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='*'){
                stack.deleteCharAt(stack.length()-1);
            }
            else{
                stack.charAt(stack.length()-1);
            }
        }
        return stack.toString();
    }
//    Method 2  using pointer
//    same complexity but more optimized
    public String removeStars2(String s) {
        char[] arr=new char[s.length()];
        int i=0;
        for (int j = 0; j < s.length(); j++) {
            char c=s.charAt(j);
            if (c=='*'){
                i--;    //index does so it overwrites backward characters
            }else {
                arr[i]=c;
                i++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}
