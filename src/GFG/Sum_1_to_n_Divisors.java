package GFG;
//Time and Space Complexity =>  O(N)   O(1)
public class Sum_1_to_n_Divisors{
    public static int sumOfDivisors(int n) {
        int sum = 0;
        // Iterating from 1 to N.
        for (int i = 1; i <= n; i++) {
            // Calculating and accumulating the sum of divisors.
            sum += (n / i) * i;
        }
        // Returning the sum of divisors.
        return sum;
    }
}
