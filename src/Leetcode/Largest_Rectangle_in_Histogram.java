package Leetcode;

import java.util.Stack;

//leetcode 84
public class Largest_Rectangle_in_Histogram {
    // Brute Force O(N^2) not good!
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            // Expand left
            int left = i;
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }

            // Expand right
            int right = i;
            while (right < n - 1 && heights[right + 1] >= height) {
                right++;
            }

            int width = right - left + 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
    // More Better Approach using Stack
    public int largestRectangleArea2(int[] heights) {
        int n=heights.length;
        int[] nse=nextSmallerElement(heights,n);
        int[] pse=previousSmallerElement(heights,n);
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int area=heights[i]*(nse[i]-pse[i]-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    private int[] nextSmallerElement(int[] heights,int n){
        Stack<Integer> stack=new Stack<>();
        int[] nse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }
    private int[] previousSmallerElement(int[] heights,int n){
        Stack<Integer> stack=new Stack<>();
        int[] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
    //  Optimize Approach
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[i]<heights[st.peek()]){
                int height=heights[st.pop()];
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                int area=height*(nse-pse-1);
                maxArea=Math.max(maxArea,area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int height=heights[st.pop()];
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            int area=height*(nse-pse-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}
