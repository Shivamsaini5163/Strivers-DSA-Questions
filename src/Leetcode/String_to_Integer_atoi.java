package Leetcode;
//leetcode 8
//Time=> O(N)  Space=> O(1)
public class String_to_Integer_atoi {
    public int myAtoi(String s) {
        int i=0;
        int sign=1;
        StringBuilder sb=new StringBuilder();
        long result=0;
        while(i<s.length()&&s.charAt(i)==' ') i++; //Skip whitespace
        if(i<s.length()&&s.charAt(i)=='+'){        //Checking Sign
            i++;
        }else if (i<s.length()&&s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        while(i<s.length()&&Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            i++;
            result = result * 10 + digit;
            if(result>Integer.MAX_VALUE){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return (int)(sign*result);
    }
}
