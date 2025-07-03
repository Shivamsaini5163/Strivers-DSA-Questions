package Leetcode;
//leetcode 8
//Time=> O(N)  Space=> O(1)
public class String_to_Integer_atoi {
    //Iterative Approach
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
    //Recursive Approach
    public int myAtoi2(String s) {
        int i=0;
        int sign=1; //by default sign will be '+'
        int n=s.length();
        while(i<n&&s.charAt(i)==' '){    //Skip Whitespaces
            i++;
        }
        if(i<s.length()&&s.charAt(i)=='+'){        //Checking Sign
            i++;
        }else if (i<s.length()&&s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        long ans=generateNumber(i,s,0,sign);
        return (int)ans;
    }
    long generateNumber(int i,String s,long res,int sign){
        if(i==s.length()|| !Character.isDigit(s.charAt(i))){
            return res*sign;
        }
        int digit=s.charAt(i)-'0';
        res=res*10+digit;
        long signedRes=res*sign;
        if (signedRes > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (signedRes < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return generateNumber(i + 1, s, res, sign);
    }
}
