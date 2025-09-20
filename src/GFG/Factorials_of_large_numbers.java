package GFG;

import java.util.ArrayList;

public class Factorials_of_large_numbers {
    public static ArrayList<Integer> factorial(int n) {
        int[] res = new int[3000]; // enough to hold 1000!
        int resSize = 1;           // number of digits currently in res
        res[0] = 1;                // initial factorial = 1

        // Multiply res[] by 2, 3, ... n
        for (int x = 2; x <= n; x++) {
            int carry = 0;
            for (int i = 0; i < resSize; i++) {
                int val = res[i] * x + carry;
                res[i] = val % 10;
                carry = val / 10;
            }
            while (carry > 0) {
                res[resSize] = carry % 10;
                carry /= 10;
                resSize++;
            }
        }

        // Convert array to ArrayList in correct order
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = resSize - 1; i >= 0; i--) {
            ans.add(res[i]);
        }
        return ans;
    }
}
