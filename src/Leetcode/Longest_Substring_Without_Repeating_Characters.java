package Leetcode;

import java.util.HashMap;
//leetcode 3
//Time and Space Complexity =>  O(N) O(N)
public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int ans=0;
        int left=0;
        int right=0;
        HashMap<Character,Integer> map=new HashMap<>();
        char[] arr=s.toCharArray();
        for (right = 0; right < arr.length; right++) {
            int idx=map.getOrDefault(arr[right],-1);
            if (idx!=-1&&left<=idx){    // idx!=-1 means this value is coming again like w ans
                // left<=idx this condition ensure that previous repeating value must be in left to current window only that range which is already discard
                // example z a b a z c b a y z suppose your left is at c and right is at last z and u are checking that is z occured before but your ans must be false because z has occured
                // but not part of our current window because that value is less than left
                ans=Math.max(ans,right-1-left+1);
                left=idx+1;
            }
            map.put(arr[right],right);
        }
        return Math.max(ans,right-1-left+1);   //using this instead of return ans because if no repeat value occured like abc then ans remain 0
    }
}
