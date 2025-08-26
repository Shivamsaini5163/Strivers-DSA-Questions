package Leetcode;

//leetcode 678
public class Valid_Parenthesis_String {
    //    Complexity  =>    O(3^N)   O(N)  using recursion
    public boolean checkValidString(String s) {
        return isValid(s, 0, 0);
    }
    boolean isValid(String s, int idx, int cnt) {
        if (cnt < 0) return false;
        if (idx == s.length()) {
            return cnt == 0;
        }
        if (s.charAt(idx) == '(') {
            return isValid(s, idx + 1, cnt + 1);
        }
        if (s.charAt(idx) == ')') {
            return isValid(s, idx + 1, cnt - 1);
        }
        return isValid(s, idx + 1, cnt + 1) || isValid(s, idx + 1, cnt - 1) || isValid(s, idx + 1, cnt);
    }

    //    Complexity  =>    O(N)   O(1) using greedy algo
    public boolean checkValidString2(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min = min + 1;
                max = max + 1;
            } else if (s.charAt(i) == ')') {
                min = min - 1;
                max = max - 1;
            } else {
                min = min - 1;
                max = max + 1;
            }
            if (min < 0) min = 0;
            if (max < 0) return false;
        }
        return min == 0;
    }
}
