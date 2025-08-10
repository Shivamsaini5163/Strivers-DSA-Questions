package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
//leetcode 239
public class Sliding_Window_Maximum {
    //Time and Space Complexity =>  O(N^2) O(1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max=Math.max(max,nums[j]);
            }
            res[i]=max;
        }
        return res;
    }
    //Time and Space Complexity =>  O(N) O(N)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        int idx=0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            // remove numbers out of range k
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[idx++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
