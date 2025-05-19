package Leetcode;

//leetcode 875
public class Koko_Eating_Bananas {
    //Brute force O(maxi × n)
    public int minEatingSpeed(int[] v, int h) {
        //Find the maximum number:
        int maxi = findMax(v);

        //Find the minimum value of k:
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(v, i);
            if (reqTime <= h) {
                return i;
            }
        }
        //dummy return statement
        return maxi;
    }
    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly)); //if you do int by int it gives you int value so no effect of ceil function on it
        }
        return totalH;
    }

    //Optimized Approach with just little changes   O(log(maxi) × n)
    public int minEatingSpeed2(int[] v, int h) {
        //Find the maximum number:
        int maxi = findMax(v);

        //Find the minimum value of k:
        int s=1;
        int e=maxi;
        while (s<=e) {
            int mid=s+(e-s)/2;
            int reqTime = calculateTotalHours(v, mid);
            if (reqTime <= h) {
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return s;
    }
}
