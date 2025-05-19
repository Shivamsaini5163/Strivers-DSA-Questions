package Leetcode;
//leetcode 1941
//Time and Space Complexity =>  O(N) O(1)
public class Check_if_All_Characters_Have_Equal_Number_of_Occurrences {
    public boolean areOccurrencesEqual(String s) {
        char[] arr=new char[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        int count=arr[s.charAt(0)-'a'];
        for(int i=0;i<26;i++){
            if(!(arr[i]==count||arr[i]==0)){
                return false;
            }
        }
        return true;
    }
}
