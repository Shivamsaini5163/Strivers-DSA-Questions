package GFG;

public class Max_Consecutive_Bit {
    public int maxConsecBits(int[] arr) {
        int max1=0;
        int max0=0;
        int one=0;
        int zero=0;
        for(int num:arr){
            if(num==0){
                zero++;
                one=0;
            }else{
                one++;
                zero=0;
            }
            max0=Math.max(zero,max0);
            max1=Math.max(one,max1);
        }
        return Math.max(max0,max1);
    }
//     This will work for more than 2 types of numbers available in array
//    more generalized and good approach
    public int maxConsecBits2(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int maxCount = 1;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
