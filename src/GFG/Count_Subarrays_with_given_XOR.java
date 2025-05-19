package GFG;

import java.util.HashMap;

public class Count_Subarrays_with_given_XOR {
    //Brute Force O(N^3)
    public long subarrayXor(int nums[], int target) {
        int cnt=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xor=0;
                for(int k=i;k<=j;k++){
                    xor=xor^nums[k];
                }
                if(xor==target){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //Better Approach O(N^2)
    public long subarrayXor2(int nums[], int target) {
        int cnt=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor^=nums[j];
                if (xor==target){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //Optimized Approach
    public long subarrayXor3(int nums[], int k) {
        long cnt=0;
        int n=nums.length;
        int xor=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            xor^=nums[i];
            if (map.containsKey(xor^k)){
                cnt+=map.get(xor^k);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return cnt;
    }
}
