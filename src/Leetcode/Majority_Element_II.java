package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//leetcode 229
public class Majority_Element_II {
    //Optimal Approach
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int count1=0,count2=0,ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(count1==0&&nums[i]!=ele2){
                count1++;
                ele1=nums[i];
            }else if(count2==0&&nums[i]!=ele1){
                count2++;
                ele2=nums[i];
            }else if(nums[i]==ele1){
                count1++;
            }else if(nums[i]==ele2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        //Check Manually
        for(int i=0;i<nums.length;i++){
            if(ele1==nums[i]) count1++;
            if(ele2==nums[i]) count2++;
        }
        ArrayList<Integer> list=new ArrayList<>();
        if(count1>n/3) list.add(ele1);
        if(count2>n/3) list.add(ele2);
        return list;
    }
    //Using hash map but space goes O(N)
    public List<Integer> majorityElement2(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>nums.length/3){
                list.add(key);
            }
        }
        return list;
    }
}
