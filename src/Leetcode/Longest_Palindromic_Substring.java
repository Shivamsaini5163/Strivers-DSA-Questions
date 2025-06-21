package Leetcode;
//leetcode 5
public class Longest_Palindromic_Substring {
    //Brute Force   O(N^3)   O(1)
    public String longestPalindrome(String s) {
        int ans=0;
        int start=0;
        int end=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)){
                    if(ans<j-i+1){
                        start=i;
                        end=j;
                        ans=j-i+1;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    private static boolean isPalindrome(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //Better Approach   O(N^2)   O(1)
    public String longestPalindrome2(String s) {
        int start=0;
        int end=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int x=expandFromCenter(i,i,s);    // for odd length
            int y=expandFromCenter(i,i+1,s);    // for even length
            int len=Math.max(x,y);
            if(end-start<len){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expandFromCenter(int left,int right,String s){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            //Expanding the string
            left--;
            right++;
        }
        return right-left-1;    //think why we use -1 instead of +1 because when condition fails we don't have palindrome string
    }
}
