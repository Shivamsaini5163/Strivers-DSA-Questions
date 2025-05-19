package Leetcode;
//leetcode 1208
//Time and Space Complexity =>    O(N) O(1)
public class Get_Equal_Substrings_Within_Budget {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s,t,maxCost));
    }
    public static int equalSubstring(String s, String t, int maxCost) {
        int left=0;
        int window=0;
        int ans=0;
        for (int right = 0; right < s.length(); right++) {
            window+=Math.abs(s.charAt(right)-t.charAt(right));
            while (maxCost<window){ //if it goes out of cost then
                window-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            ans=Integer.max(ans,right-left+1);
        }
        return ans;
    }
}
