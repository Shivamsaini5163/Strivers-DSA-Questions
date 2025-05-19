package Leetcode;

import java.util.HashMap;
//leetcode 205
//Time and Space Complexity =>  O(N) O(N)
public class Isomorphic_Strings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        char[] str1= s.toCharArray();
        char[] str2= t.toCharArray();
        HashMap<Character,Character> mapS=new HashMap<>();
        for (int i = 0; i < str1.length; i++) {
            if (mapS.containsKey(str1[i])){
                if (mapS.get(str1[i])!=str2[i]){
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
