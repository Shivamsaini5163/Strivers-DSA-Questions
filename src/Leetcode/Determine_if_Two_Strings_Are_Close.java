package Leetcode;

import java.util.Arrays;
//leetcode 1657
//Time and Space Complexity =>  O(N) O(N)
//Note we use sorting here still complexity is not n log n because it sorting applied here on an array with constant 26 length space
public class Determine_if_Two_Strings_Are_Close {
    public static void main(String[] args) {
        String word1= "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1,word2));
    }
    public static boolean closeStrings(String word1, String word2) {
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        for (char ch:word1.toCharArray()) {
            arr1[ch-'a']++;
        }
        for (char ch:word2.toCharArray()) {
            arr2[ch-'a']++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]>0&&arr2[i]==0){     //  checking that is there any character that is present in word1 but not in word2
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
}
