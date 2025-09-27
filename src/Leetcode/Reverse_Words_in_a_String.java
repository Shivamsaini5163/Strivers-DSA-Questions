package Leetcode;

import java.util.Stack;
//leetcode 151
public class Reverse_Words_in_a_String {
    //Using String Methods  O(N)   O(N)
    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        int n=words.length;
        if(n==0) return s;
        for(int i=n-1;i>=0;i--){
            if (!words[i].isEmpty()) {           // skip empty strings from extra space
                if (sb.length() > 0) sb.append(" ");  // add space only between words
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }
    //Using Stack  O(N)   O(N)
    public String reverseWords2(String s) {
        String[] words = s.trim().split(" ");
        Stack<String> stack = new Stack<>();
        for (String word : words) {
            if(!word.isEmpty()){
                stack.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }
    //Optimized Approach   O(N)   O(1)
    public String reverseWords3(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        // 1. Reverse the whole string
        reverse(arr,0,n-1);
        // 2. Reverse each word
        reverseEachWord(arr,n);
        // 3. Clean spaces
        return cleanSpaces(arr, n);
    }
    void reverse(char[] arr,int left,int right){
        //Using two pointers method
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    void reverseEachWord(char[] arr,int n){
        int start=0,end=0;
        while(start<n){
            while(start<n&&arr[start]==' ') start++;    //skip spaces
            end=start;
            while (end < n && arr[end] != ' ') end++; // find word end
            reverse(arr, start, end - 1);
            start=end;
        }
    }
    String cleanSpaces(char[]arr,int n){
        int i=0,j=0;
        while(j<n){
            while(j<n&&arr[j]==' ') j++;    // skip leading spaces before a word
            while(j<n&&arr[j]!=' ') arr[i++]=arr[j++];    /// copy word
            while(j<n&&arr[j]==' ') j++;    // skip spaces after the word
            if (j < n) arr[i++] = ' '; // add one space if another word exists
        }
        return new String(arr, 0, i);
    }
}
