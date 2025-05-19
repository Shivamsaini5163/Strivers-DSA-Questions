package Leetcode;

import java.util.HashSet;
import java.util.Set;
//leetcode 791
//Time and Space Complexity =>    O(M+N) O(M+N)
public class Custom_Sort_String {
    public String customSortString(String order, String s) {
        StringBuilder sb=new StringBuilder();
        Set<Character> set=new HashSet<>();
        int[] ca=new int[26];
        for (char i:order.toCharArray()) {
            set.add(i);
        }
        for (char i:s.toCharArray()) {
            if (!set.contains(i)){
                sb.append(i);
            }else {
                ca[i-'a']++;
            }
        }
        for (char i:order.toCharArray()) {
            int count=ca[i-'a'];
            while(count > 0){
                sb.append(i);
                count--;
            }
        }
        return sb.toString();
    }
}
