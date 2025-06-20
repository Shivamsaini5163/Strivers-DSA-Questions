package Leetcode;

import java.util.*;
//leetcode 451
//Time and Space Complexity =>  O(N) O(N)
public class Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        ArrayList<Character>[] arr=new ArrayList[s.length()+1];  //array as bucket as frequency (using bucket sort)
        for (char ch:s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (char ch:map.keySet()) {
            if (arr[map.get(ch)]==null){
                arr[map.get(ch)]=new ArrayList<>();
            }
            arr[map.get(ch)].add(ch);
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]!=null){
                for (Character c:arr[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
