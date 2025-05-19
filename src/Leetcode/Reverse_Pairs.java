package Leetcode;

import java.util.ArrayList;

//leetcode 493
public class Reverse_Pairs {
    //Brute Force O(N^2)
    public int reversePairs(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((long)nums[i]>(long)2*nums[j])   count++;
            }
        }
        return count;
    }
    //Optimal Approach  (NlogN)
    //almost same as count inversion problem of gfg
    public int reversePairs2(int[] arr) {
        return merge_sort(arr,0,arr.length-1);
    }
    private static int merge_sort(int[] arr,int l,int h){
        int cnt=0;
        if(l<h){
            int mid=l+(h-l)/2;
            cnt+=merge_sort(arr,l,mid);
            cnt+=merge_sort(arr,mid+1,h);
            cnt+=countPairs(arr,l,mid,h);//modification  we calculate pair possible before merge
            merge(arr,l,mid,h);
        }
        return cnt;
    }
    private static void merge(int[] arr,int l,int mid,int h){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=l;
        int right=mid+1;
        int cnt = 0;
        while(left<=mid&&right<=h){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=h){
            temp.add(arr[right]);
            right++;
        }
        for (int i = l; i <= h; i++) {
            arr[i] = temp.get(i - l);
        }
    }
    private static int countPairs(int[] arr,int l,int mid, int h){
        int right=mid+1;
        int cnt = 0;
        for(int i=l;i<=mid;i++){
            while(right<=h&&arr[i]>(long)2*arr[right]){
                right++;
            }
            cnt+=right-(mid+1);
        }
        return cnt;
    }
}
