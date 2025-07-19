package Leetcode;

//leetcode 383
//Time and Space Complexity =>  O(N) O(1)
public class Ransom_Note {
    public static void main(String[] args) {
        String ransomNote = "cf";
        String magazine = "fuck";
        System.out.println(canConstruct(ransomNote,magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int[] A=new int[26];
        for(char ch:magazine.toCharArray()){
            A[ch-'a']++;
        }
        for(char ch:ransomNote.toCharArray()){
            A[ch-'a']--;
        }
        for(int i:A){
            if(i<0) return false;
        }
        return true;
    }
}
