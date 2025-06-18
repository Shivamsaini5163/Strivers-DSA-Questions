package Leetcode;
//leetcode 1903
public class Largest_Odd_Number_in_String {
    //Brute Force    Time=> O(N)    Space=>O(N)
    public String largestOddNumber(String num) {
        StringBuilder ans=new StringBuilder(num);
        for (int i=num.length()-1;i>=0;i--) {
            if((ans.charAt(i)-'0')%2==0){
                ans.deleteCharAt(i);
            }else return ans.toString();
        }
        return "";
    }
    //Optimized Approach    Time=> O(N)    Space=>O(1)
    public String largestOddNumber2(String num) {
        for (int i=num.length()-1;i>=0;i--) {
            if((num.charAt(i)-'0')%2==1){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
