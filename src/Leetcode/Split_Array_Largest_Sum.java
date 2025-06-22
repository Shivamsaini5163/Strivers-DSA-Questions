package Leetcode;
//leetcode 410
//Same as Allocate_Minimum_Pages(GFG)
public class Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int k) {
        int l=0;
        int h=0;
        for(int num:nums){
            l=Math.max(l,num);
            h+=num;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(count(nums,mid)<=k) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
    private static int count(int[] arr,int pagesAllowed){
        int pagesUsed=0;
        int student=1;
        for(int num:arr){
            pagesUsed+=num;
            if(pagesUsed>pagesAllowed){
                student++;
                pagesUsed=num;
            }
        }
        return student;
    }
}
