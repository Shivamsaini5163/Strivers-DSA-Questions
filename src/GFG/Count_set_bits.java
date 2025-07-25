package GFG;

public class Count_set_bits {
    //Brute Force O(NlogN)
    public static int countSetBits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int num=i;
            while(num!=0){
                if((num&1)==1) count++;
                num=num>>1;
            }
        }
        return count;
    }
    //Better Approach O(NlogN)
    public static int countSetBits2(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int num=i;
            while(num!=0){
                num=num&(num-1);
                count++;
            }
        }
        return count;
    }
    //Optimal Approach O(logN) use DP

}
