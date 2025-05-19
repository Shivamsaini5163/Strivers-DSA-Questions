package Leetcode;
//leetcode 69
public class Sqrt_x {
    //Brute Force
    public int mySqrt(int n) {
        int ans=0;
        for (long i = 1; i <= n; i++) {
            long val = i * i;
            if (val <= (long) n) {
                ans = (int) i;
            } else {
                break;
            }
        }
        return ans;
    }
    //Optimised Approach
    public int mySqrt2(int n) {
        long l=0;
        long h=n;
        while(l<=h){
            long mid=l+(h-l)/2;
            long value=mid*mid;
            if(value==n){
                return (int)mid;
            }else if(value>n){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return (int)h;
    }
}
