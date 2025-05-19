package Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
//leetcode 239
//Time and Space Complexity =>  O(N) O(N)
public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr,3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue=new ArrayDeque<>();//its first value always has index of our ans(i.e. max in window)
        int n=nums.length;
        int[] res=new int[n-k+1];
        int idx=0;
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){    //remove one by one from last because if some greater one comes then smaller has no significance for storing
                queue.pollLast();
            }
            queue.addLast(i);   //add that new one element index in last
            if (queue.getFirst()+k==i){//if max index present at out of range if we can say behind the window so remove it from queue
                queue.removeFirst();
            }
            if (i>=k-1){   // it makes sure that window is of size k then only it add to ans
                res[idx++]=nums[queue.getFirst()];
            }
        }
        return res;
    }
}
