package GFG;

import java.util.ArrayList;
import java.util.List;

public class Frequencies_in_a_Limited_Array {
    //  Easy to understand taking extra array
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        int n=arr.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[arr[i]-1]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(res[i]);
        }
        return ans;
    }
    //  complex to understand but no extra array taking so more optimized
    public List<Integer> frequencyCount2(int[] arr) {
        int n = arr.length;

        // Step 1: Decrease all elements by 1 to make the range 0 to n-1
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - 1;
        }

        // Step 2: Use elements as index and increase value at that index by n
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Step 3: The frequency of element (i+1) will be arr[i] / n
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(arr[i] / n);
        }

        return ans;
    }
}
