package GFG;

import java.util.ArrayList;

public class Prime_Factors {
    //  O(sqrt(N)*sqrt(N))=>  O(N)      O(1)    //Brute Force
    public static ArrayList<Integer> primeFac(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                if(isPrime(i)){
                    list.add(i);
                }
                if(isPrime(n/i)&&(n/i)!=i){
                    list.add(n/i);
                }
            }
        }
        if(isPrime(n)){
            list.add(n);
        }
        return list;
    }
    static boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    // O(sqrt(N))   O(1)    //Optimised Approach
    public static ArrayList<Integer> primeFac2(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                list.add(i);
                while(n%i==0){
                    n=n/i;
                }
            }
        }
        if(n!=1){   //means that number is itself prime and it never got divisible by anyone that is why it is still same number
            list.add(n);
        }
        return list;
    }
}
