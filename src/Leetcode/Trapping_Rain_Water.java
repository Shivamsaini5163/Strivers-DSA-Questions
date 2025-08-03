package Leetcode;
//leetcode 42
public class Trapping_Rain_Water {
    //But Not Optimized O(N)   O(N)     prefix/suffix arrays approach 🔥
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        //Store left max for all indices
        int max=height[0];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(max,height[i]);
            max=leftMax[i];
        }
        //Store right max for all indices
        rightMax[n-1]=height[n-1];
        max=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(max,height[i]);
            max=rightMax[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int h=Math.min(leftMax[i],rightMax[i]);
            ans+=h-height[i];
        }
        return ans;
    }
    //Optimized O(N)   O(1)     Two Pointer Approach
    public int trap2(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
