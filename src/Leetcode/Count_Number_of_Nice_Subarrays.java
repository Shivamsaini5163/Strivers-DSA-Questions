package Leetcode;

import java.util.HashMap;

//leetcode 1248
//Time and Space Complexity =>  O(N) O(N)
public class Count_Number_of_Nice_Subarrays {
    public static void main(String[] args) {
        int[] nums={1,1,2,1,1};
        int k=3;
        System.out.println(numberOfSubarrays2(nums,k));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int ans=0;
        int odd=0;  //no of odd values up to a particular point
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            odd+=nums[i]%2; //if it is odd value it contribute 1 value otherwise not
            ans+=map.getOrDefault(odd-k,0);
            map.put(odd,map.getOrDefault(odd,0)+1);
        }
        return ans;
    }
    //more optimize approach
    public static int numberOfSubarrays2(int[] nums, int k) {
        int ans=0;
        int odd=0;
        int[] arr=new int[nums.length+1];
        arr[0]=1;
        for(int i:nums){
            odd+=i%2;
            if (odd - k >= 0) {
                ans += arr[odd - k];
            }
            arr[odd]++;
        }
        return ans;
    }
    //Best Solution     O(N) O(1) Same Approach used in Leetcode 930 Binary Subarrays With Sum
    public int numberOfSubarrays3(int[] nums, int goal) {
        return numSubarraysLessOrEqualThanSum(nums,goal)-numSubarraysLessOrEqualThanSum(nums,goal-1);
    }
    int numSubarraysLessOrEqualThanSum(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int r=0;
        int l=0;
        int sum=0;
        int cnt=0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>goal){
                sum-=nums[l]%2;
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}