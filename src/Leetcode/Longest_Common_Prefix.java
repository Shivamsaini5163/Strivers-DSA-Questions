package Leetcode;

import java.util.Arrays;

//leetcode 14
public class Longest_Common_Prefix {
    //Brute Force    Time=> O(M*N)    Space=>O(1)
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        int pos=0;
        for(char ch:strs[0].toCharArray()){
            for(int i=1;i<n;i++){
                if(strs[i].length()<=pos||strs[i].charAt(pos)!=ch){
                    return strs[0].substring(0,pos);
                }
            }
            pos++;
        }
        return strs[0];
    }
    //Optimized Approach    Time=> O(NlogN)   Space=> O(1)
    public String longestCommonPrefix2(String[] strs) {
        int n=strs.length;
        int pos=0;
        Arrays.sort(strs);
        String a=strs[0];
        String b=strs[n-1];
        int i = 0, len = Math.min(a.length(), b.length());
        while (i < len && a.charAt(i) == b.charAt(i)) i++;  //matching so going forward
        return a.substring(0, i);
    }
}
