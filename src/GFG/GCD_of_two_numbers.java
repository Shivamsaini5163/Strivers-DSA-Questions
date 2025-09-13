package GFG;

public class GCD_of_two_numbers {
    //Brute Force
    public static int gcd(int a, int b) {
        int gcd=1;
        for(int i=1;i<=Math.min(a,b);i++){
            if(a%i==0&&b%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
//    Optimize Approach
    public static int gcd2(int a, int b) {
//        almost same as swap number using third variable
//        So, the problem of finding GCD(a, b) reduces to finding GCD(b, r), and this process is repeated until the remainder becomes 0.
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    //Recursive Approach
    public static int gcd3(int a, int b) {
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
