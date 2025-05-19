package Leetcode;
//leetcode 50
public class Pow_x_n{
    public double myPow(double x, int n) {
        double ans=1;
        long N=n;
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