package Leetcode;
//leetcode 33
//Time and Space Complexity =>  O(logN) O(1)
public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr={3,4,5,6,7,0,1,2};
        int target=6;
        System.out.println(search(arr,target));
    }
    //ignore everything this is best code
    public int search3(int[] nums, int k) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==k){
                return mid;
            }else if(nums[l]<=nums[mid]){
                if(nums[l]<=k&&nums[mid]>=k){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<=k&&nums[h]>=k){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
    static int search(int[] arr,int target){
        int p=pivot(arr);
        if(p==-1)
            return Bsearch(arr,target,0,arr.length-1);
        if(arr[p]==target)
            return p;
        if(target>=arr[0])
            return Bsearch(arr,target,0,p-1);
        return Bsearch(arr,target,p+1,arr.length-1);
    }
    //this one is good use this instead of below one
    static int pivot(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m<e && arr[m] > arr[m+1]) {
                return m;
            }
            if (s<m && arr[m] < arr[m-1]) {
                return m-1;
            }
            if (arr[m] <= arr[s]) {
                e=m-1;
            }
            else
                s = m+1;
        }
        return -1;
    }
    //better approach to find pivot using binary search
    private static int findPivot2(int[] nums){
        int l=0;
        int h=nums.length-1;
        //Edge Cases
        if(nums.length==1){
            return -1;
        }
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid]>=nums[l]){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return -1;
    }
    static int Bsearch(int[] arr,int target,int s,int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] < target)
                s= m+1;
            else if (arr[m] > target)
                e = m - 1;
            else
                return m;
        }
        return -1;
    }
}