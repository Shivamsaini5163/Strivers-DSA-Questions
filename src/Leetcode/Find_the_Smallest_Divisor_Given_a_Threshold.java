package Leetcode;
//leetcode 1283
public class Find_the_Smallest_Divisor_Given_a_Threshold {
    public static void main(String[] args) {
        int[] nums={1,2,5,9};
        int threshold=6;
        System.out.println(smallestDivisor(nums,threshold));
    }
    //Brute Force O(max(nums)×n)
    public static int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        for(int i=1;i<=max;i++){
            int sum=calculateSum(nums,i,n);
            if(sum<=threshold){
                return i;
            }
        }
        return -1;
    }
    static int calculateSum(int[] nums,int divisor,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double)nums[i]/(double)divisor);
        }
        return sum;
    }
    //Optimized Approach O(n*log(max(nums)))
    public static int smallestDivisor2(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int l=1;
        int h=max;
        while(l<=h){
            int mid=l+(h-l)/2;
            int sum=calculateSum(nums,mid,n);
            if(sum<=threshold){
                h=mid-1;
            } else {
                l=mid+1;
            }
        }
        return l;
    }
}
