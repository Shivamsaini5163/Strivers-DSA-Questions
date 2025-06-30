package Leetcode;
//leetcode 50
public class Pow_x_n{
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
}