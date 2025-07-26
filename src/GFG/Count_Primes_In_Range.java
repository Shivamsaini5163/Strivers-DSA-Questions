package GFG;

import java.util.Arrays;

public class Count_Primes_In_Range{
    int countPrimes(int L, int R) {
        int size=200001;
        boolean[] isPrime = new boolean[size];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= size; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < size; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count=0;
        for (int i = L; i <= R; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
