package Leetcode;
//leetcode 796
public class Rotate_String {
    //Brute Force   O(N^2) O(N)
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int n=s.length();
        for(int i=0;i<n;i++){
            s=s.substring(1)+s.charAt(0);   //rotate the string
            if(s.equals(goal)) return true;
        }
        return false;
    }
    //Optimized Approach    O(N) O(N)
    public boolean rotateString2(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        return (s+s).contains(goal);    //s+s contains all combinations of rotations possible
    }
}
