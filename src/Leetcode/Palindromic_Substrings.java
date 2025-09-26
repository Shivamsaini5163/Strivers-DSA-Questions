package Leetcode;

//  leetcode 647
public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        // same as leetcode 5 Longest Palindromic Substring
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            ans+=expandFromCenter(i,i,s);    // for odd length
            ans+=expandFromCenter(i,i+1,s);    // for even length
        }
        return ans;
    }
    private int expandFromCenter(int left,int right,String s){
        int res=0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            res++; // increment the count
            //Expanding the string
            left--;
            right++;
        }
        return res;
    }
}
