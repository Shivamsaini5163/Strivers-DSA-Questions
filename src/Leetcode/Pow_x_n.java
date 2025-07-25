package Leetcode;
//leetcode 50
public class Pow_x_n{
// Using Recursion
//    O(logN)        O(logN)
    public double myPow(double x, int n) {
        long N=n;   // Convert to long to handle -2^31 safely   -n == Integer.MIN_VALUE
//                     == -(-2147483648)
//                     == -2147483648   still same, because of overflow!
        if(N<0){
            N*=-1;
            x=1/x;
        }
        return helper(x,N);
    }
    private double helper(double x, long n){
        if(n==0) return 1;
        double half=helper(x,n/2);
        double result=half*half;
        if(n%2==1){
            result*=x;
        }
        return result;
    }
    // Use Bit Manipulation
    //  O(logN)       O(1)  Best Approach
    public double myPow2(double x, int n) {
        long N = n; // Convert to long to handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) { // If the lowest bit is 1
                result *= x;
                N-=1;
            }else{
                x = x*x;     // Square the base
                N >>= 1;    // Right shift N by 1 (divide by 2)
            }
        }
        return result;
    }
}