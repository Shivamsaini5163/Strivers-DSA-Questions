package Leetcode;
//leetcode 13
public class Roman_to_Integer {
//    Question 1    O(N)    O(1)
    public int romanToInt(String s) {
        int[] VAL = new int[26];
        VAL['I' - 'A'] = 1;
        VAL['V' - 'A'] = 5;
        VAL['X' - 'A'] = 10;
        VAL['L' - 'A'] = 50;
        VAL['C' - 'A'] = 100;
        VAL['D' - 'A'] = 500;
        VAL['M' - 'A'] = 1000;
        int n   = s.length();
        int ans = 0;
        int i   = 0;
        while (i < n - 1) {
            int curr = VAL[s.charAt(i)-'A'];
            int next = VAL[s.charAt(i + 1)-'A'];
            if (curr >= next) {
                ans += curr;
                i++;
            } else {
                ans += next - curr;
                i += 2;
            }
        }
        if (i == n - 1) ans += VAL[s.charAt(i) - 'A'];
        return ans;
    }
    //    Question 2    O(1)    O(1)
    public static String intToRoman(int num) {
        // Define Roman numeral values and their corresponding symbols
        int[] values =    {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,   1};
        String[] symbols ={"M",  "CM","D", "CD","C", "XC","L", "XL","X", "IX","V", "IV","I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
