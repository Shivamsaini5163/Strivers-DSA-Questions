package GFG;

public class Min_Swaps_to_Group_1s {
    public int minSwaps(int[] arr) {
        // Using sliding window
        //  find the total ones
        int totalOnes=0;
        int n=arr.length;
        for(int num:arr){
            if(num==1) totalOnes++;
        }
        if(totalOnes==0) return -1;
        // Find 1's for first subarray
        // of length x
        int count_ones = 0;
        int x=totalOnes;
        for (int i = 0; i < x; i++) {
            if (arr[i] == 1)
                count_ones++;
        }
        int maxOnes = count_ones;
        // using sliding window technique
        // to find max number of ones in
        // subarray of length x
        for (int i = 1; i <= n - x; i++) {

            if (arr[i - 1] == 1)
                count_ones--;

            if (arr[i + x - 1] == 1)
                count_ones++;

            if (maxOnes < count_ones)
                maxOnes = count_ones;
        }
        // calculate number of zeros in
        // subarray of length x with
        // maximum number of 1's
        int numberOfZeroes = x - maxOnes;

        return numberOfZeroes;
    }
}
