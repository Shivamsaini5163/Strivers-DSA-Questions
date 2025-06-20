package Leetcode;
//leetcode 744
public class Find_Smallest_Letter_Greater_Than_Target {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (letters[m] <= target)
                s = m + 1;
            else
                e = m - 1;
        }
        return letters[s % letters.length];
    }
}
