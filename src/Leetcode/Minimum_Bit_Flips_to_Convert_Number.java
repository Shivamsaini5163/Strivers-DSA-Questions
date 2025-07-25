package Leetcode;

//leetcode 2220
public class Minimum_Bit_Flips_to_Convert_Number {
//    O(K)     O(1)
    public int minBitFlips(int start, int goal) {
        int n=start^goal;   // only those bits become 1 which need to be flip
        //count no. of set bits in n
        int ans=0;
        while(n!=0){
            n=n&(n-1);
            ans++;
        }
        return ans;
    }
}
