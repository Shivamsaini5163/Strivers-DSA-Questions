package Leetcode;

import java.util.Stack;

//leetcode 402
//Complexity=>      O(N)       O(N)
//Using Monotonic Stack
public class Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k--;
            }
            st.push(ch);    // stores increasing values
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) return "0";
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        // ✅ Reverse first
        res.reverse();

        // ✅ Now safely remove leading zeros
        int idx = 0;
        while (idx < res.length() && res.charAt(idx) == '0') {
            idx++;
        }

        String result = res.substring(idx);
        return result.isEmpty() ? "0" : result;
    }
}
