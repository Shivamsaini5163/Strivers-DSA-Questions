package Leetcode;

import java.util.HashMap;
//leetcode 2342
//Time and Space Complexity =>  O(N) O(N)
public class Max_Sum_of_Pair_With_Equal_Sum_of_Digits{
    public static void main(String[] args) {
        int[] nums={18,43,36,13,7};
        System.out.println(maximumSum(nums));
    }
    public static int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int s=digitSum(nums[i]);
            if(map.containsKey(digitSum(nums[i]))){
                ans=Math.max(ans,nums[i]+map.get(s));
                int newValue=Math.max(nums[i],map.get(s));
                map.put(s,newValue);
            }
            else {
                map.put(s,nums[i]);
            }
        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
    private static int digitSum(int num){
        int sum=0;
        while(num!=0){
            int digit=num%10;
            sum+=digit;
            num=num/10;
        }
        return sum;
    }
}
