package Leetcode;

import java.util.HashMap;

//leetcode 260
public class Single_Number_III {
    //Brute Force   O(N)   O(N)
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] ans=new int[2];
        int idx=0;
        for(int num:map.keySet()){
            if(map.get(num)==1){
                ans[idx++]=num;
            }
        }
        return ans;
    }
    //Optimized Approach O(N)  O(1)   using Bit Manipulation
    public int[] singleNumber2(int[] nums) {
        int XOR=0; //  We use long instead of int in c++ because it will crash for xor=2^-31 for (xor-1) but in java 2's complement used so no worry
        for(int num:nums){
            XOR=XOR^num;
        }
        //Use to differentiate and decide which bucket should it send to
        int rightmost=(XOR&(XOR-1))^XOR;    // number which has only one rightmost set bit
        int bucket1=0;
        int bucket2=0;
        for(int num:nums){
            if((rightmost&num)!=0){
                bucket1=bucket1^num;
            }else{
                bucket2=bucket2^num;
            }
        }
        return new int[]{bucket1,bucket2};
    }
}
