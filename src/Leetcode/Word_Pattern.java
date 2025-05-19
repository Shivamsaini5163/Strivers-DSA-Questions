package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
//leetcode 2824
//Time and Space Complexity =>  O(N) O(N)
public class Word_Pattern {
    public static void main(String[] args) {
        String pattern = "aaaa";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }
    public static boolean wordPattern(String pattern, String s) {
        char[] str1= pattern.toCharArray();
        String[] str2= s.split(" ");
        HashMap<Character,String> mapS=new HashMap<>();
        if (str2.length!=str1.length){
            return false;
        }
        for (int i = 0; i < str1.length; i++) {
            if (mapS.containsKey(str1[i])){
                if (!mapS.get(str1[i]).equals(str2[i])){
                    return false;
                }
            }
            else {
                if (mapS.containsValue(str2[i])){
                    return false;
                }
                mapS.put(str1[i],str2[i]);
            }
        }
        return true;
    }
}
