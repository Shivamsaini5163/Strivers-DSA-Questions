package Leetcode;
//leetcode 1832
//Time and Space Complexity =>    O(N) O(1)
import java.util.HashSet;

public class Check_if_the_Sentence_Is_Pangram {
    //this is best to use
    public boolean checkIfPangram(String s) {
        boolean[] arr=new boolean[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=true;
        }
        for(int i=0;i<arr.length;i++){
            if(!arr[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkIfPangram2(String s) {
        //this is also good
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            set.add(s.charAt(i));
        }
        if(set.size()==26){
            return true;
        }
        return false;
    }
    public boolean checkIfPangram3(String s) {
        //this uses contains()many times repeatedly
        char ch='a';
        for(int i=0;i<26;i++){
            if(s.contains(String.valueOf(ch))) ch++;
            else return false;
        }
        return true;
    }
}
