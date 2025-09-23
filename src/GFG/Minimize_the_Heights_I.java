package GFG;

import java.util.Arrays;

public class Minimize_the_Heights_I {
    public int getMinDiff(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int ans=arr[n-1]-arr[0];
        // Try all possible splits
        // Left part (0 to i-1) → increase by k → candidates for high, not low
        // Right part (i to n-1) → decrease by k → candidates for low, because decreasing might create a new minimum
        for(int i=1;i<n;i++){
            int high=Math.max(arr[i-1]+k,arr[n-1]-k);
            int low=Math.min(arr[i]-k,arr[0]+k);
            ans=Math.min(ans,high-low);
        }
        return ans;
    }
}
