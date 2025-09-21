package Leetcode;

//leetcode 258
public class Add_Digits {
    public int addDigits(int num) {
        if (num == 0) return 0;       // digital root of 0 is 0
        if (num % 9 == 0) return 9;   // multiples of 9 have digital root 9
        return num % 9;                // all other numbers
    }
}
