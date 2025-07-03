package Leetcode;
//leetcode 1922
//  O(logN)       O(logN)
public class Count_Good_Numbers {
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long mod=(long)(Math.pow(10,9)+7);
        return (int)(Power(5,even,mod)*Power(4,odd,mod)%mod);
    }
    private long Power(int x, long n,long mod){
        if(n==0) return 1;
        long half=Power(x,n/2,mod);
        long result=(half*half)%mod;
        if(n%2==1){
            result=(result*x)%mod;
        }
        return result;
    }
}
