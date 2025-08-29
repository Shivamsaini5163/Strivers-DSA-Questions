package GFG;

import java.util.Arrays;

//Brute Force O(N^2)
public class Minimum_Platforms {
    public int findPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] <= arr[i] && arr[i] <= dep[j]) cur++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
    //Optimize Approach O(N) using greedy approach
    public int findPlatform2(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat = 0, maxPlat = 0;
        int i = 0, j = 0;
        while(i < n && j < n){
            // Arrival comes first (arrivals at the same time as departures need new platform)
            if (arr[i] <= dep[j]) {
                plat++;
                maxPlat = Math.max(maxPlat, plat);
                i++;
            } else {
                plat--;
                j++;
            }
        }
        return maxPlat;
    }
}
