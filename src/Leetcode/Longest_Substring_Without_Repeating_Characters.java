package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode 3
public class Longest_Substring_Without_Repeating_Characters {
    // Best Code, use this one
    public int lengthOfLongestSubstring3(String s) {
        // HashMap to store the last index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        int left = 0;  // Start of the sliding window
        int ans = 0;   // Stores the length of longest substring

        // Iterate over each character in the string
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // If the character is already in the current window
            if (map.containsKey(c)) {
                // Move 'left' just past the previous occurrence of c
                // Math.max ensures left never moves backward
                left = Math.max(left, map.get(c) + 1);
            }

            // Update the last seen index of the current character
            map.put(c, right);

            // Update the maximum length of substring found so far
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
    //Time and Space Complexity =>  O(N^2) O(N)
    public int lengthOfLongestSubstring(String str) {
        if(str.length()==0)
            return 0;
        int maxans = 0;
        for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
        {
            Set< Character > se = new HashSet< >();
            for (int j = i; j < str.length(); j++) // nested loop for getting different
            // string starting with str[i]
            {
                if (se.contains(str.charAt(j))) // if element if found so mark it as ans
                // and break from the loop
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
            // Ensure we update when no duplicate is found
            maxans = Math.max(maxans, se.size());
        }
        return maxans;
    }
    //Time and Space Complexity =>  O(N) O(N)
    public static int lengthOfLongestSubstring2(String s) {
        int ans=0;
        int left=0;
        int right=0;
        HashMap<Character,Integer> map=new HashMap<>();
        char[] arr=s.toCharArray();
        for (right = 0; right < arr.length; right++) {
            int idx=map.getOrDefault(arr[right],-1);
            if (idx!=-1&&left<=idx){    // idx!=-1 means this value is coming again like w ans
                // left<=idx this condition ensure that previous repeating value must be in left to current window only that range which is already discard
                // example z a b a z c b a y z suppose your left is at c and right is at last z and u are checking that is z occurred before but your ans must be false because z has occurred
                // but not part of our current window because that value is less than left
                ans=Math.max(ans,right-1-left+1);
                left=idx+1;
            }
            map.put(arr[right],right);
        }
        return Math.max(ans,right-1-left+1);   //using this instead of return ans because if no repeat value occurred like abc then ans remain 0
    }
}
