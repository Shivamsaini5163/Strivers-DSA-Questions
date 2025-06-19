package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
//leetcode 242
public class Valid_Anagram {
    //Brute Force   O(NlogN)   O(N)
    public boolean isAnagram(String s, String t) {
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
    //Better Approach   O(N)   O(K)
    public boolean isAnagram2(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }
            map.put(ch,map.get(ch)-1);
            if(map.get(ch)==0){
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
    //Optimized Approach O(N)   O(1)
    public boolean isAnagram3(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] count=new char[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int c:count){
            if(c!=0){
                return false;
            }
        }
        return true;
    }
}
