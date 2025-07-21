package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode 49
//Brute Force O(N × K log K)
//Grouping all String with sorted string used as key in map
public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String sorted_str = new String(arr);
            if(!map.containsKey(sorted_str)){
                map.put(sorted_str,new ArrayList<>());
            }
            map.get(sorted_str).add(str);
        }
        return new ArrayList<>(map.values());
    }
    //Optimize Approach O(N * k) we compute a unique pattern for every string and check if it is already exists in map or not
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            int[] count=new int[26];
            for(char ch:str.toCharArray()){
                count[ch-'a']++;
            }
            //Now generate pattern
            StringBuilder sb=new StringBuilder();
            for(int i:count){
                sb.append('#');
                sb.append(i);
            }
            String key=new String(sb);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
