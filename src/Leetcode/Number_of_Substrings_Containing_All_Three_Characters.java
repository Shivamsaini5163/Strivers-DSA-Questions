package Leetcode;

//leetcode 1358
public class Number_of_Substrings_Containing_All_Three_Characters {
//    Brute Force O(N^2)    O(1)
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']++;
                if(hash[0]>0&&hash[1]>0&&hash[2]>0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
//    Slightly Better
    public int numberOfSubstrings2(String s) {
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']++;
                if(hash[0]>0&&hash[1]>0&&hash[2]>0){
                    cnt+=n-j;
                    break;
                }
            }
        }
        return cnt;
    }
    //Optimize Approach O(N)   O(1)
    public int numberOfSubstrings3(String s) {
        int n=s.length();
        int cnt=0;
        int[] hash={-1,-1,-1};
        for(int i=0;i<n;i++){
            hash[s.charAt(i)-'a']=i;   //update last seen value
            if(hash[0]!=-1&&hash[1]!=-1&&hash[2]!=-1){
                cnt+=Math.min(hash[0],Math.min(hash[1],hash[2]))+1;
            }
        }
        return cnt;
    }
}
