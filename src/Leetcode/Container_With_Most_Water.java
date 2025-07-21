package Leetcode;

//leetcode 11
public class Container_With_Most_Water {
    //Brute Force   O(N^2)
    public int maxArea(int[] height) {
        int n=height.length;
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int area=Math.min(height[i],height[j])*(j-i);
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
    //Optimized Approach
    public int maxArea2(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxArea=0;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,area);
            //Now we have to make a decision that which pointer to move
            //we need to make sure that height which is greater, not gets excluded
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}
