package Leetcode;

import java.util.Stack;
//leetcode 151
public class Reverse_Words_in_a_String {
    //Using String Methods  O(N)   O(N)
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
        { if(!arr[i].isEmpty())
            res.append(arr[i]).append(" ");
        }
        return res.toString().trim();
    }
    //Using Stack  O(N)   O(N)
    public String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for (String word : words) {
            stack.push(word);
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
            while(j<n&&arr[j]==' ') j++;    //skip spaces
            while(j<n&&arr[j]!=' ') arr[i++]=arr[j++];    //skip spaces
            while(j<n&&arr[j]==' ') j++;    //skip spaces
            if (j < n) arr[i++] = ' '; // add one space if needed
        }
        return new String(arr, 0, i);
    }
}
