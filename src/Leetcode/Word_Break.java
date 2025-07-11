package Leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//leetcode 139
public class Word_Break {
//    Brute Force :   Basic Recursive Approach
//    Time complexity: Exponential → O(2^n) in worst case and Space Complexity: O(n^2)
//    Repeated sub problems → e.g., checking the same suffix again and again
    public boolean wordBreak(String s, List<String> wordDict) {
        return canBreak(s, wordDict);
    }
    boolean canBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                if (canBreak(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Optimized Approach :      Recursive + Memoization
    // O(n^2)        O(n)
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);  // fast lookup
        Map<String, Boolean> memo = new HashMap<>(); // memoization
        return canBreak2(s, dict, memo);
    }
    private boolean canBreak2(String s, Set<String> dict, Map<String, Boolean> memo) {
        if (s.isEmpty()) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = s.substring(i);
                if (canBreak2(suffix, dict, memo)) {
                    //store those strings which are breakable as prefix and suffix and found in dict
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}
