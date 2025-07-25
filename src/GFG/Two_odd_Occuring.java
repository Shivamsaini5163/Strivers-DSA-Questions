package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Two_odd_Occuring {
    //Brute Force   O(N* (K log K))=> O(N)       O(N)
    ArrayList<Integer> twoOddNum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int idx = 0;
        for (int num : map.keySet()) {
            if (map.get(num) % 2 == 1) {
                ans.add(num);
            }
        }
        ans.sort((a, b) -> b - a);
        return ans;
    }

    //    Optimized Approach
    ArrayList<Integer> twoOddNum2(int[] nums) {
        int XOR = 0; //  We use long instead of int in c++ because it will crash for xor=2^-31 for (xor-1) but in java 2's complement used so no worry
        for (int num : nums) {
            XOR = XOR ^ num;
        }
        //Use to differentiate and decide which bucket should it send to
        int rightmost = (XOR & (XOR - 1)) ^ XOR;    // number which has only one rightmost set bit
        int bucket1 = 0;
        int bucket2 = 0;
        for (int num : nums) {
            if ((rightmost & num) != 0) {
                bucket1 = bucket1 ^ num;
            } else {
                bucket2 = bucket2 ^ num;
            }
        }
        int a = Math.max(bucket1, bucket2);
        int b = Math.min(bucket1, bucket2);
        return new ArrayList<>(Arrays.asList(a, b));
    }
}
