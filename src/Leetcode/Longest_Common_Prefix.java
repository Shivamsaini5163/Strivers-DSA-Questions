package Leetcode;
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
}
