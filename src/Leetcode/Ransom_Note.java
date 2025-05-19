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
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        for(int i=0;i<ransomNote.length();i++){
            arr1[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++){
            arr2[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr1[i]>arr2[i]){
                return false;
            }
        }
        return true;
    }
}
