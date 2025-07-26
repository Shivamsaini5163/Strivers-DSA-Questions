package GFG;

import java.util.ArrayList;
import java.util.List;

//  O(Nlog(log(N))      O(N)
public class Prime_Factorization_using_Sieve {
    static int size=200001;
    static int[] spf=new int[size]; // smallest prime factor for every number
    static boolean sieveBuilt = false;
    // You must implement this function
    static void sieve() {
        if (sieveBuilt) return; // if already done
        // Step 1: Sieve to fill spf[]
        for(int i=0;i<size;i++){
            spf[i]=i;
        }
        for(int i=2;i*i<=size;i++){
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j < size; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i; // update only first time
                    }
                }
            }
        }
        sieveBuilt = true;
    }

    static List<Integer> findPrimeFactors(int n) {
        sieve();  // make sure SPF is computed
        List<Integer> list=new ArrayList<>();
        while(n!=1){
            int prime=spf[n];
            list.add(prime);
            n=n/prime;
        }
        return list;
    }
}
