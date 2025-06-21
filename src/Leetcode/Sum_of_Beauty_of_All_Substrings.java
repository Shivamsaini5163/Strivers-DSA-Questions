package Leetcode;

import java.util.HashMap;
//leetcode 1781
public class Sum_of_Beauty_of_All_Substrings {
    //Brute Force   O(N^3)    O(1)
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans+=findBeauty(i,j,s);
            }
        }
        return ans;
    }
    private int findBeauty(int start,int end,String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=start;i<=end;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int x:map.values()){
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        return max-min;
    }
    //Optimized solution   O(N^2)    O(1)
    public int beautySum2(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
                for(int x:freq){
                    if(x>0){// we are interested in only those character which have appeared in string if we take those which have not appeared then they corrupt our min variable
                        min=Math.min(min,x);
                        max=Math.max(max,x);
                    }
                }
                ans+=max-min;
            }
        }
        return ans;
    }
}
