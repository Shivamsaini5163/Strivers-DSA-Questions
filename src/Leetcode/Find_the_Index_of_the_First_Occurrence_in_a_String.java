package Leetcode;
//leetcode 28
public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        for(int i=0;i<=m-n;i++){
            if(haystack.substring(i,n+i).equals(needle)) return i;
        }
        return -1;
    }
    //Without substring() method
    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Loop through haystack
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            // Compare character by character
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i; // All characters matched
            }
        }

        return -1; // No match found
    }
}
