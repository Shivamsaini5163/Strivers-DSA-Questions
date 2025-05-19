package Leetcode;

import java.util.*;
//leetcode 18
public class Four_Sum {
    //More Optimized O(N^3*logM)    Space O(N)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // size of the array
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(null);
                        set.add(temp);
                    }
                    // put the kth element into the hashset:
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    //Best Approach O(N^3)    Space O(1)
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            //Skip Duplicates
            if(i!=0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                //Skip Duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum>target){
                        l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        list.add(temp);
                        k++;
                        l--;
                        //Skip duplicates
                        while(k<l&&nums[k]==nums[k-1]) k++;
                        while(k<l&&nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        return list;
    }
}
