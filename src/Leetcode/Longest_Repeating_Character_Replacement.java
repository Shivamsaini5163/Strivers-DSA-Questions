package Leetcode;

//leetcode 424
public class Longest_Repeating_Character_Replacement {
    //Brute Force   O(N^2)  O(26)
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int maxlen=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[26];
            int maxfreq=0;
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'A']++;
                maxfreq=Math.max(maxfreq,hash[s.charAt(j)-'A']);
                int changes=(j-i+1)-maxfreq;
                if(changes<=k){
                    maxlen=Math.max(maxlen,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxlen;
    }
    //Optimize Approach  O(2*N*26)  O(26)
    public int characterReplacement2(String s, int k) {
        int n=s.length();
        int maxlen=0,left=0,maxfreq=0;
        int[] hash=new int[26];
        for(int right=0;right<n;right++){
            hash[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,hash[s.charAt(right)-'A']);
            while((right-left+1)-maxfreq>k){
                hash[s.charAt(left)-'A']--;
                maxfreq=0;
                for(int i=0;i<26;i++){
                    maxfreq=Math.max(maxfreq,hash[i]);
                }
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
    //Optimize Approach  O(N)   O(26)
    public int characterReplacement3(String s, int k) {
        int n=s.length();
        int maxlen=0,left=0,maxfreq=0;
        int[] hash=new int[26];
        for(int right=0;right<n;right++){
            hash[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,hash[s.charAt(right)-'A']);
            if((right-left+1)-maxfreq>k){
                hash[s.charAt(left)-'A']--;
                maxfreq=0;
                left++;
            }
            if((right-left+1)-maxfreq<=k){
                maxlen=Math.max(maxlen,right-left+1);
            }
        }
        return maxlen;
    }
}
