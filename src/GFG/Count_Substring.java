package GFG;

public class Count_Substring {
    //Brute Force   O(N^2)     O(1)
    public static int countSubstring(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            int a = 0, b = 0, c = 0;
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                if (ch == 'a') a++;
                else if (ch == 'b') b++;
                else if (ch == 'c') c++;
                if (a > 0 && b > 0 && c > 0) {
                    count++;
                }
            }
        }
        return count;
    }
    //Optimized Approach   O(N)     O(1)
    public static int countSubstring2(String s) {
        int n=s.length();
        int left=0,right=0;
        int ans=0;
        int[] freq=new int[3];
        for(right=0;right<n;right++){
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0&&freq[1]>0&&freq[2]>0){
                ans+=n-right;
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return ans;
    }
}
