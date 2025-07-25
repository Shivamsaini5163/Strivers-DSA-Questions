package Leetcode;

//leetcode 29
public class Divide_Two_Integers {
    //using bit manipulation because using *,/,% not allowed
    //    O(log N)    O(1)
    public int divide(int dividend, int divisor) {
        //manage overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend==divisor) return 1;
        int sign=1; // +ve
        if(dividend>=0&&divisor<0) sign=0;  // -ve
        if(dividend<=0&&divisor>0) sign=0;  // -ve
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        long ans=0;
        while(n>=d){
            int power=0;
            while(n>=(d<<(power+1))){
                power++;
            }
            ans=ans+(1<<power);
            n=n-(d*(1<<power));
        }
        //manage overflow
        if(ans==(1<<31) && sign == 1) return Integer.MAX_VALUE;
        if(ans==(1<<31) && sign == 0) return Integer.MIN_VALUE;
        return sign==1?(int)ans:(int)(-1*ans);
    }
}
