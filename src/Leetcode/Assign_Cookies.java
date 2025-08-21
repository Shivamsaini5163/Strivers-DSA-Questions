package Leetcode;

import java.util.Arrays;

//leetcode 455
//Using Greedy Algorithm    O(n log n + m log m)    O(1)
public class Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
