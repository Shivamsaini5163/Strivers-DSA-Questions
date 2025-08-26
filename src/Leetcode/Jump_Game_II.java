package Leetcode;
//leetcode 45
public class Jump_Game_II {
//    Brute Force
    //Time and Space Complexity => O(N^N) O(N)
    public int jump(int[] nums) {
        return fun(0,0,nums);
    }
    int fun(int ind,int jumps,int[] nums){
        if(ind>=nums.length-1){
            return jumps;
        }
        int minjump=Integer.MAX_VALUE;
        for(int i=1;i<=nums[ind];i++){
            minjump=Math.min(minjump,fun(ind+i,jumps+1,nums));
        }
        return minjump;
    }
    //Time and Space Complexity => O(N) O(1)
    public int jump2(int[] arr) {
        int n=arr.length;
        if (n <= 1) return 0; // No jumps needed if array has one element
        if (arr[0] == 0) return -1; // Cannot move forward if the first element is 0
        int jumps=0;
        int l=0;
        int r=0;
        int farthest=0;
        while(r<n-1){
            for(int i=l;i<=r;i++){
                farthest=Math.max(i+arr[i],farthest);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}
