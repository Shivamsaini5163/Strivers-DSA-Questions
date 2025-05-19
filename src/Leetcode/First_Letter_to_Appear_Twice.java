package Leetcode;
//leetcode 2351
//Time and Space Complexity =>    O(N) O(N)
//Space Complexity: O(n), where n is the number of unique characters in the string.
//        In the worst case, we may have to store all characters in the HashSet
//        if there are no duplicates until the end. Since the input consists of lowercase English letters,
//        this will at most take O(26) space, but we count it as O(n) for generality.
import java.util.HashSet;

public class First_Letter_to_Appear_Twice {
    public static void main(String[] args) {
        String s = "abccbaacz";
        System.out.println(repeatedCharacter(s));
    }
    public static char repeatedCharacter(String s) {
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                return s.charAt(i);
            }
            set.add(s.charAt(i));
        }
        return ' ';
    }
}
