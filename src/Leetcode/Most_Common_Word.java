package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode 819
public class Most_Common_Word {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.toLowerCase().replaceAll("[!?',;.]"," ");
        String[] words=paragraph.split(" ");
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(String word : words){
            if(!bannedSet.contains(word) && word.length() > 0){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        String res="";
        int maxlength=0;
        for(String word:map.keySet()){
            if(maxlength<=map.get(word)){
                res=word;
            }
            maxlength=Math.max(maxlength,map.get(word));
        }
        return res;
    }
}
