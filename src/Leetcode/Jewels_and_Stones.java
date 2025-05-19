package Leetcode;

import java.util.HashSet;

public class Jewels_and_Stones {
//leetcode 771
//Time and Space Complexity =>  O(N) O(1)
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels,stones));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        int ans=0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(String.valueOf(stones.charAt(i)))){
                ans++;
            }
        }
        return ans;
    }
    public static int numJewelsInStones2(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();

        // Add all jewels to the set
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;
        // Iterate over stones and count how many are jewels
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}
