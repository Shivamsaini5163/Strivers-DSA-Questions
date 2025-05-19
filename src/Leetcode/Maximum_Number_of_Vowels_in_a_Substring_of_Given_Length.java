package Leetcode;
//leetcode 1456
//Time and Space Complexity =>    O(N) O(1)
public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public static void main(String[] args) {
        String s="abciiidef";
        int k=3;
        System.out.println(maxVowels(s,k));
    }
    public static int maxVowels(String s, int k) {
        int left=0;
        int ans=0;
        int window=0;
        for (int right = 0; right < k; right++) {
            if (isVowel(s.charAt(right))){
                ans+=1;
            }
        }
        window=ans;
        for (int right = k; right < s.length(); right++) {
            if (isVowel(s.charAt(right))){
                window+=1;
            }
            if (isVowel(s.charAt(left))){
                window-=1;
            }
            left++;
            ans=Math.max(ans,window);
        }
        return ans;
    }
    private static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
}