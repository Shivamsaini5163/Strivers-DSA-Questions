package Leetcode;

import java.util.*;

//leetcode 137
public class Single_Number_II {
//    Brute Force   O(N)   O(N)
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)==1) return key;
        }
        return -1;
    }
    //  O(NlogN)    O(1)
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i += 3) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[n - 1]; // Unique element is at the end
    }
    //Better Approach (Easy to Think)
    // O(32*N)=>O(N)     O(1)
    public int singleNumber3(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int bitCount=0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    bitCount++;
                }
            }
            if(bitCount%3!=0) ans|=1<<i;
        }
        return ans;
    }
    //Optimized Approach (Complex to think)
    //  O(N)      O(1)
    public int singleNumber4(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}
