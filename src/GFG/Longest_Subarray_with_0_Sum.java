package GFG;

import java.util.HashMap;
//Time and Space Complexity =>    O(N) O(N)
//Use Prefix Sum and Hashing
public class Longest_Subarray_with_0_Sum {
    int maxLen(int arr[]) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                maxLen=i+1;
            }
            if(map.containsKey(sum)){
                maxLen=Math.max(maxLen,i-map.get(sum));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}
