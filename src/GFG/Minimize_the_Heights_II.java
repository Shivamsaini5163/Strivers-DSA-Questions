package GFG;

import java.util.Arrays;

public class Minimize_the_Heights_II {
    public int getMinDiff(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int ans=arr[n-1]-arr[0];
        for(int i=1;i<n;i++){
            int high=Math.max(arr[i-1]+k,arr[n-1]-k);
            int low=Math.min(arr[i]-k,arr[0]+k);
            if(low<0) continue;
            ans=Math.min(ans,high-low);
        }
        return ans;
    }
}
