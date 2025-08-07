package Leetcode;

import java.util.Stack;

//leetcode 85
//Almost same as leetcode 84 Largest Rectangle in Histogram
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] prefixSum=new int[row][col];
        for(int j=0;j<col;j++){
            int sum=0;
            for(int i=0;i<row;i++){
                int val = matrix[i][j] - '0'; // ✅ Convert char to int
                sum+=val;
                if(val==0){
                    sum=0;
                }
                prefixSum[i][j]=sum;
            }
        }
        int maxArea=0;
        for(int i=0;i<row;i++){
            maxArea=Math.max(maxArea,findMaxArea(prefixSum[i]));
        }
        return maxArea;
    }
    public int findMaxArea(int[] heights) {
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
